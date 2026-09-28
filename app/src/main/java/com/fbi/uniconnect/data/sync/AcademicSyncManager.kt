package com.fbi.uniconnect.data.sync

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
                async { SyncResource.SCHEDULES to remote.getSchedules() },
                async { SyncResource.ATTENDANCE to remote.getAttendances() },
                async { SyncResource.GRADES to remote.getGrades() },
                async { SyncResource.KRS to remote.getKrs() },
                async { SyncResource.ASSIGNMENTS to remote.getAssignments() },
                async { SyncResource.ANNOUNCEMENTS to remote.getAnnouncements() },
            )

            val results = operations.awaitAll()
            val states = linkedMapOf<SyncResource, SyncResourceState>()

            results.forEach { (resource, result) ->
                states[resource] = when (result) {
                    is com.fbi.uniconnect.core.network.NetworkResult.Success -> {
                        if (result.data.isEmpty()) {
                            SyncResourceState.EmptyRemote
                        } else {
                            when (resource) {
                                SyncResource.SCHEDULES -> store.replaceSchedules(result.data as List<com.fbi.uniconnect.data.model.CourseSchedule>)
                                SyncResource.ATTENDANCE -> store.replaceAttendances(result.data as List<com.fbi.uniconnect.data.model.Attendance>)
                                SyncResource.GRADES -> store.replaceGrades(result.data as List<com.fbi.uniconnect.data.model.Grade>)
                                SyncResource.KRS -> store.replaceKrs(result.data as List<com.fbi.uniconnect.data.model.Krs>)
                                SyncResource.ASSIGNMENTS -> store.replaceAssignments(result.data as List<com.fbi.uniconnect.data.model.Assignment>)
                                SyncResource.ANNOUNCEMENTS -> store.replaceAnnouncements(result.data as List<com.fbi.uniconnect.data.model.Announcement>)
                            }
                            SyncResourceState.Updated
                        }
                    }
                    is com.fbi.uniconnect.core.network.NetworkResult.HttpError -> SyncResourceState.Failed(result)
                    is com.fbi.uniconnect.core.network.NetworkResult.NetworkError -> SyncResourceState.Failed(result)
                }
            }

            val completedAt = System.currentTimeMillis()
            val fullySuccessful = states.values.all {
                it is SyncResourceState.Updated || it is SyncResourceState.EmptyRemote
            }
            val previousSuccessfulAt = store.getLastSuccessfulSyncAt()
            val successfulAt = if (fullySuccessful) completedAt else previousSuccessfulAt
            store.saveSyncMetadata(nowEpochMillis, successfulAt)

            AcademicSyncResult(
                resources = states,
                attemptedAtEpochMillis = nowEpochMillis,
                completedAtEpochMillis = completedAt,
                lastSuccessfulSyncAtEpochMillis = successfulAt,
            )
        }
}
