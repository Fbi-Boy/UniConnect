package com.fbi.uniconnect.data.model

data class Assignment(
    val id: String,
    val title: String,
    val courseName: String,
    val description: String,
    val dueDate: String,
    val dueTime: String,
    val status: String,
)
