package com.fbi.uniconnect.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey val id: String,
    val name: String,
    val nim: String,
    val studyProgram: String,
    val semester: Int,
    val gpa: Double,
)

@Entity(tableName = "lecturers")
data class LecturerEntity(
    @PrimaryKey val id: String,
    val name: String,
    val nidn: String,
    val department: String,
    val email: String,
)

@Entity(tableName = "admins")
data class AdminEntity(
    @PrimaryKey val id: String,
    val name: String,
    val email: String,
)

@Entity(tableName = "course_schedules")
data class CourseScheduleEntity(
    @PrimaryKey val id: String,
    val courseName: String,
    val lecturerName: String,
    val day: String,
    val startTime: String,
    val endTime: String,
    val room: String,
)

@Entity(tableName = "attendances")
data class AttendanceEntity(
    @PrimaryKey val id: String,
    val courseName: String,
    val date: String,
    val status: String,
    val note: String?,
)

@Entity(tableName = "grades")
data class GradeEntity(
    @PrimaryKey val id: String,
    val courseName: String,
    val sks: Int,
    val score: Double,
    val letter: String,
)

@Entity(tableName = "krs")
data class KrsEntity(
    @PrimaryKey val id: String,
    val courseName: String,
    val courseCode: String,
    val sks: Int,
    val lecturerName: String,
    val status: String,
)

@Entity(tableName = "assignments")
data class AssignmentEntity(
    @PrimaryKey val id: String,
    val title: String,
    val courseName: String,
    val description: String,
    val dueDate: String,
    val dueTime: String,
    val status: String,
)

@Entity(tableName = "announcements")
data class AnnouncementEntity(
    @PrimaryKey val id: String,
    val title: String,
    val content: String,
    val publisher: String,
    val publishedAt: String,
    val category: String,
)
