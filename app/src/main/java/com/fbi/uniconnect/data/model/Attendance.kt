package com.fbi.uniconnect.data.model

import com.fbi.uniconnect.domain.model.AttendanceStatus

data class Attendance(
    val id: String,
    val courseName: String,
    val date: String,
    val status: AttendanceStatus,
    val note: String? = null,
)