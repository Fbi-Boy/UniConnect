package com.fbi.uniconnect.data.sync

import com.fbi.uniconnect.core.database.AcademicSyncMetadataDao
import com.fbi.uniconnect.core.database.AcademicSyncMetadataEntity
import com.fbi.uniconnect.core.database.AnnouncementDao
import com.fbi.uniconnect.core.database.AssignmentDao
import com.fbi.uniconnect.core.database.AttendanceDao
import com.fbi.uniconnect.core.database.GradeDao
import com.fbi.uniconnect.core.database.KrsDao
import com.fbi.uniconnect.core.database.ScheduleDao
import com.fbi.uniconnect.core.database.toEntity
import com.fbi.uniconnect.data.model.Announcement
import com.fbi.uniconnect.data.model.Assignment
import com.fbi.uniconnect.data.model.Attendance
import com.fbi.uniconnect.data.model.CourseSchedule
import com.fbi.uniconnect.data.model.Grade
import com.fbi.uniconnect.data.model.Krs
import javax.inject.Inject
import javax.inject.Singleton

interface AcademicSyncStore {
    suspend fun replaceSchedules(items: List<CourseSchedule>)
    suspend fun replaceAttendances(items: List<Attendance>)
    suspend fun replaceGrades(items: List<Grade>)
    suspend fun replaceKrs(items: List<Krs>)
    suspend fun replaceAssignments(items: List<Assignment>)
    suspend fun replaceAnnouncements(items: List<Announcement>)
    suspend fun saveSyncMetadata(attemptedAt: Long, successfulAt: Long?)
    suspend fun getLastSuccessfulSyncAt(): Long?
}

@Singleton
class RoomAcademicSyncStore @Inject constructor(
    private val scheduleDao: ScheduleDao,
    private val attendanceDao: AttendanceDao,
    private val gradeDao: GradeDao,
    private val krsDao: KrsDao,
    private val assignmentDao: AssignmentDao,
    private val announcementDao: AnnouncementDao,
    private val metadataDao: AcademicSyncMetadataDao,
) : AcademicSyncStore {
    override suspend fun replaceSchedules(items: List<CourseSchedule>) =
        scheduleDao.replaceAll(items.map { it.toEntity() })

    override suspend fun replaceAttendances(items: List<Attendance>) =
        attendanceDao.replaceAll(items.map { it.toEntity() })

    override suspend fun replaceGrades(items: List<Grade>) =
        gradeDao.replaceAll(items.map { it.toEntity() })

    override suspend fun replaceKrs(items: List<Krs>) =
        krsDao.replaceAll(items.map { it.toEntity() })

    override suspend fun replaceAssignments(items: List<Assignment>) =
        assignmentDao.replaceAll(items.map { it.toEntity() })

    override suspend fun replaceAnnouncements(items: List<Announcement>) =
        announcementDao.replaceAll(items.map { it.toEntity() })

    override suspend fun saveSyncMetadata(attemptedAt: Long, successfulAt: Long?) {
        metadataDao.upsert(
            AcademicSyncMetadataEntity(
                id = ACADEMIC_SYNC_ID,
                lastAttemptAtEpochMillis = attemptedAt,
                lastSuccessfulAtEpochMillis = successfulAt,
            ),
        )
    }

    override suspend fun getLastSuccessfulSyncAt(): Long? =
        metadataDao.get(ACADEMIC_SYNC_ID)?.lastSuccessfulAtEpochMillis

    private companion object {
        const val ACADEMIC_SYNC_ID = "academic"
    }
}
