package com.fbi.uniconnect.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class HealthResponse(val status: String)

@Serializable
data class ApiErrorResponse(
    val code: String? = null,
    val message: String? = null,
)

@Serializable
data class ScheduleDto(
    val id: String,
    val courseName: String,
    val lecturerName: String,
    val day: String,
    val startTime: String,
    val endTime: String,
    val room: String,
)

@Serializable
data class AttendanceDto(
    val id: String,
    val courseName: String,
    val date: String,
    val status: String,
    val note: String? = null,
)

@Serializable
data class GradeDto(
    val id: String,
    val courseName: String,
    val sks: Int,
    val score: Double,
    val letter: String,
)

@Serializable
data class KrsDto(
    val id: String,
    val courseName: String,
    val courseCode: String,
    val sks: Int,
    val lecturerName: String,
    val status: String,
)

@Serializable
data class AssignmentDto(
    val id: String,
    val title: String,
    val courseName: String,
    val description: String,
    val dueDate: String,
    val dueTime: String,
    val status: String,
)

@Serializable
data class AnnouncementDto(
    val id: String,
    val title: String,
    val content: String,
    val publisher: String,
    val publishedAt: String,
    val category: String,
)
