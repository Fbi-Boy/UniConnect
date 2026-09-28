package com.fbi.uniconnect.data.sync

import com.fbi.uniconnect.core.network.NetworkResult
import com.fbi.uniconnect.data.model.Announcement
import com.fbi.uniconnect.data.model.Assignment
import com.fbi.uniconnect.data.model.Attendance
import com.fbi.uniconnect.data.model.CourseSchedule
import com.fbi.uniconnect.data.model.Grade
import com.fbi.uniconnect.data.model.Krs
import com.fbi.uniconnect.data.remote.AcademicRemoteSource
import javax.inject.Inject
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class AcademicSyncManager @Inject constructor(
    private val remote: AcademicRemoteSource,
    private val store: AcademicSyncStore,
) {
    suspend fun sync(nowEpochMillis: Long = System.currentTimeMillis()): AcademicSyncResult =
        coroutineScope {
            val operations = listOf(
                SyncOperation(SyncResource.SCHEDULES, { remote.getSchedules() }) { store.replaceSchedules(it) },
                SyncOperation(SyncResource.ATTENDANCE, { remote.getAttendances() }) { store.replaceAttendances(it) },
                SyncOperation(SyncResource.GRADES, { remote.getGrades() }) { store.replaceGrades(it) },
                SyncOperation(SyncResource.KRS, { remote.getKrs() }) { store.replaceKrs(it) },
                SyncOperation(SyncResource.ASSIGNMENTS, { remote.getAssignments() }) { store.replaceAssignments(it) },
                SyncOperation(SyncResource.ANNOUNCEMENTS, { remote.getAnnouncements() }) { store.replaceAnnouncements(it) },
            )

            val states = operations.map { operation ->
                async { operation.resource to execute(operation) }
            }.awaitAll().toMap()

            val completedAt = System.currentTimeMillis()
            val fullySuccessful = states.values.all {
                it is SyncResourceState.Updated || it is SyncResourceState.EmptyRemote
            }
            val successfulAt = if (fullySuccessful) completedAt else store.getLastSuccessfulSyncAt()
            store.saveSyncMetadata(nowEpochMillis, successfulAt)

            AcademicSyncResult(
                resources = states,
                attemptedAtEpochMillis = nowEpochMillis,
                completedAtEpochMillis = completedAt,
                lastSuccessfulSyncAtEpochMillis = successfulAt,
            )
        }

    private suspend fun <T> execute(operation: SyncOperation<T>): SyncResourceState =
        when (val result = operation.request()) {
            is NetworkResult.Success -> {
                if (result.data.isEmpty()) {
                    SyncResourceState.EmptyRemote
                } else {
                    operation.save(result.data)
                    SyncResourceState.Updated
                }
            }
            is NetworkResult.HttpError -> SyncResourceState.Failed(result)
            is NetworkResult.NetworkError -> SyncResourceState.Failed(result)
        }

    private data class SyncOperation<T>(
        val resource: SyncResource,
        val request: suspend () -> NetworkResult<List<T>>,
        val save: suspend (List<T>) -> Unit,
    )
}
