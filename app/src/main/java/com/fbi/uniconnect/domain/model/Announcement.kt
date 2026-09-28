package com.fbi.uniconnect.domain.model

data class Announcement(
    val id: String,
    val title: String,
    val content: String,
    val publisher: String,
    val publishedAt: String,
    val category: AnnouncementCategory,
)

enum class AnnouncementCategory(val label: String) {
    ACADEMIC("Akademik"),
    CAMPUS("Kampus"),
    EVENT("Acara"),
    SYSTEM("Sistem"),
}
