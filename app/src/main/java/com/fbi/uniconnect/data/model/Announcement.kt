package com.fbi.uniconnect.data.model

data class Announcement(
    val id: String,
    val title: String,
    val content: String,
    val publisher: String,
    val publishedAt: String,
    val category: String,
)
