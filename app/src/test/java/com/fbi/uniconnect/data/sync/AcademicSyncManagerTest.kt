package com.fbi.uniconnect.data.sync

import com.fbi.uniconnect.core.network.NetworkResult
import com.fbi.uniconnect.data.model.Announcement
import com.fbi.uniconnect.data.model.Assignment
import com.fbi.uniconnect.data.model.Attendance
import com.fbi.uniconnect.data.model.CourseSchedule
import com.fbi.uniconnect.data.model.Grade
import com.fbi.uniconnect.data.model.Krs
import com.fbi.uniconnect.data.remote.AcademicRemoteSource
import com.fbi.uniconnect.domain.model.AttendanceStatus
import com.fbi.uniconnect.domain.model.DayOfWeek
import com.fbi.uniconnect.domain.model.GradeLetter
import com.fbi.uniconnect.domain.model.KrsStatus
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AcademicSyncManagerTest {
    @Test
    fun successfulResponsesReplaceEachCache() = runTest {
        val store = FakeStore()
        val result = AcademicSyncManager(FakeRemote(), store).sync(1_000L)

        assertTrue(result.isFullySuccessful)
        assertEquals(6, store.totalWrites)
        assertEquals(1, store.metadataWrites)
        assertEquals(1, store.scheduleWrites)
        assertEquals(1, store.attendanceWrites)
        assertEquals(1, store.gradeWrites)
        assertEquals(1, store.krsWrites)
        assertEquals(1, store.assignmentWrites)
        assertEquals(1, store.announcementWrites)
        assertEquals(1_000L, store.lastAttemptAt)
    }

    @Test
    fun emptyRemoteResponseDoesNotTouchLocalCache() = runTest {
        val store = FakeStore()
        val result = AcademicSyncManager(EmptyRemote(), store).sync(2_000L)

        assertTrue(result.isFullySuccessful)
        assertTrue(result.resources.values.all { it is SyncResourceState.EmptyRemote })
        assertEquals(0, store.totalWrites)
        assertEquals(2_000L, store.lastAttemptAt)
    }

    @Test
    fun networkFailurePreservesSuccessfulResourcesAndTimestamp() = runTest {
        val store = FakeStore(previousSuccessfulAt = 900L)
        val result = AcademicSyncManager(PartialFailureRemote(), store).sync(3_000L)

        assertEquals(listOf(SyncResource.ATTENDANCE), result.failedResources)
        assertEquals(1, store.scheduleWrites)
        assertEquals(0, store.attendanceWrites)
        assertEquals(900L, result.lastSuccessfulSyncAtEpochMillis)
        assertEquals(3_000L, store.lastAttemptAt)
    }

    private class FakeRemote : AcademicRemoteSource {
        override suspend fun getSchedules() = NetworkResult.Success(listOf(schedule))
        override suspend fun getAttendances() = NetworkResult.Success(listOf(attendance))
        override suspend fun getGrades() = NetworkResult.Success(listOf(grade))
        override suspend fun getKrs() = NetworkResult.Success(listOf(krs))
        override suspend fun getAssignments() = NetworkResult.Success(listOf(assignment))
        override suspend fun getAnnouncements() = NetworkResult.Success(listOf(announcement))
    }

    private class EmptyRemote : AcademicRemoteSource {
        override suspend fun getSchedules() = NetworkResult.Success(emptyList<CourseSchedule>())
        override suspend fun getAttendances() = NetworkResult.Success(emptyList<Attendance>())
        override suspend fun getGrades() = NetworkResult.Success(emptyList<Grade>())
        override suspend fun getKrs() = NetworkResult.Success(emptyList<Krs>())
        override suspend fun getAssignments() = NetworkResult.Success(emptyList<Assignment>())
        override suspend fun getAnnouncements() = NetworkResult.Success(emptyList<Announcement>())
    }

    private class PartialFailureRemote : AcademicRemoteSource {
        override suspend fun getSchedules() = NetworkResult.Success(listOf(schedule))
        override suspend fun getAttendances() = NetworkResult.NetworkError(IllegalStateException("offline"))
        override suspend fun getGrades() = NetworkResult.Success(listOf(grade))
        override suspend fun getKrs() = NetworkResult.Success(listOf(krs))
        override suspend fun getAssignments() = NetworkResult.Success(listOf(assignment))
        override suspend fun getAnnouncements() = NetworkResult.Success(listOf(announcement))
    }

    private class FakeStore(private val previousSuccessfulAt: Long? = null) : AcademicSyncStore {
        var scheduleWrites = 0
        var attendanceWrites = 0
        var gradeWrites = 0
        var krsWrites = 0
        var assignmentWrites = 0
        var announcementWrites = 0
        var metadataWrites = 0
        var lastAttemptAt: Long? = null

        val totalWrites: Int
            get() = scheduleWrites + attendanceWrites + gradeWrites + krsWrites +
                assignmentWrites + announcementWrites

        override suspend fun replaceSchedules(items: List<CourseSchedule>) { scheduleWrites++ }
        override suspend fun replaceAttendances(items: List<Attendance>) { attendanceWrites++ }
        override suspend fun replaceGrades(items: List<Grade>) { gradeWrites++ }
        override suspend fun replaceKrs(items: List<Krs>) { krsWrites++ }
        override suspend fun replaceAssignments(items: List<Assignment>) { assignmentWrites++ }
        override suspend fun replaceAnnouncements(items: List<Announcement>) { announcementWrites++ }

        override suspend fun saveSyncMetadata(attemptedAt: Long, successfulAt: Long?) {
            metadataWrites++
            lastAttemptAt = attemptedAt
        }

        override suspend fun getLastSuccessfulSyncAt(): Long? = previousSuccessfulAt
    }

    private companion object {
        val schedule = CourseSchedule("sync-schedule", "Pemrograman Mobile", "Budi", DayOfWeek.MONDAY, "08:00", "09:40", "Lab")
        val attendance = Attendance("sync-attendance", "Pemrograman Mobile", "28 September 2026", AttendanceStatus.PRESENT)
        val grade = Grade("sync-grade", "Pemrograman Mobile", 3, 92.0, GradeLetter.A)
        val krs = Krs("sync-krs", "Pemrograman Mobile", "TIF301", 3, "Budi", KrsStatus.APPROVED)
        val assignment = Assignment("sync-assignment", "Sync test", "Pemrograman Mobile", "Test", "30 September 2026", "23:59", "PENDING")
        val announcement = Announcement("sync-announcement", "Sync test", "Test", "Akademik", "28 September 2026", "ACADEMIC")
    }
}
