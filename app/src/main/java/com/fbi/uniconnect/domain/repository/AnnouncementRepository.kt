package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.Announcement

interface AnnouncementRepository {
    fun getAnnouncements(): List<Announcement>
}
