package com.fbi.uniconnect.domain.model

data class Attendance(
    val id: String,
    val courseName: String,
    val date: String,
    val status: AttendanceStatus,
    val note: String? = null,
)

enum class AttendanceStatus(val label: String) {
    PRESENT("Hadir"),
    ABSENT("Tidak Hadir"),
    LATE("Terlambat"),
    EXCUSED("Izin"),
}