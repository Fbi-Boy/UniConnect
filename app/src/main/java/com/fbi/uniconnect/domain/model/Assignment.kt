package com.fbi.uniconnect.domain.model

data class Assignment(
    val id: String,
    val title: String,
    val courseName: String,
    val description: String,
    val dueDate: String,
    val dueTime: String,
    val status: AssignmentStatus,
)

enum class AssignmentStatus(val label: String) {
    PENDING("Belum dikerjakan"),
    SUBMITTED("Sudah dikumpulkan"),
    OVERDUE("Terlambat"),
}
