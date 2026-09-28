package com.fbi.uniconnect.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        StudentEntity::class,
        LecturerEntity::class,
        AdminEntity::class,
        CourseScheduleEntity::class,
        AttendanceEntity::class,
        GradeEntity::class,
        KrsEntity::class,
        AssignmentEntity::class,
        AnnouncementEntity::class,
        AcademicSyncMetadataEntity::class,
    ],
    version = 2,
    exportSchema = true,
)
abstract class UniConnectDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun lecturerDao(): LecturerDao
    abstract fun adminDao(): AdminDao
    abstract fun scheduleDao(): ScheduleDao
    abstract fun attendanceDao(): AttendanceDao
    abstract fun gradeDao(): GradeDao
    abstract fun krsDao(): KrsDao
    abstract fun assignmentDao(): AssignmentDao
    abstract fun announcementDao(): AnnouncementDao
    abstract fun academicSyncMetadataDao(): AcademicSyncMetadataDao
}
