package com.fbi.uniconnect.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * FROM students LIMIT 1")
    suspend fun getCurrent(): StudentEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: StudentEntity)
}

@Dao
interface LecturerDao {
    @Query("SELECT * FROM lecturers LIMIT 1")
    suspend fun getCurrent(): LecturerEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lecturer: LecturerEntity)
}

@Dao
interface AdminDao {
    @Query("SELECT * FROM admins LIMIT 1")
    suspend fun getCurrent(): AdminEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(admin: AdminEntity)
}

@Dao
interface ScheduleDao {
    @Query("SELECT * FROM course_schedules ORDER BY id")
    suspend fun getAll(): List<CourseScheduleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<CourseScheduleEntity>)
}

@Dao
interface AttendanceDao {
    @Query("SELECT * FROM attendances ORDER BY id")
    suspend fun getAll(): List<AttendanceEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<AttendanceEntity>)
}

@Dao
interface GradeDao {
    @Query("SELECT * FROM grades ORDER BY id")
    suspend fun getAll(): List<GradeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<GradeEntity>)
}

@Dao
interface KrsDao {
    @Query("SELECT * FROM krs ORDER BY id")
    suspend fun getAll(): List<KrsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<KrsEntity>)
}

@Dao
interface AssignmentDao {
    @Query("SELECT * FROM assignments ORDER BY id")
    suspend fun getAll(): List<AssignmentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<AssignmentEntity>)
}

@Dao
interface AnnouncementDao {
    @Query("SELECT * FROM announcements ORDER BY id")
    suspend fun getAll(): List<AnnouncementEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<AnnouncementEntity>)
}
