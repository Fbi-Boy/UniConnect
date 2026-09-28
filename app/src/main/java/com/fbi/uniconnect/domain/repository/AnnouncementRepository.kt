package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.Announcement

interface AnnouncementRepository {
    suspend fun getAnnouncements(): List<Announcement>
}
