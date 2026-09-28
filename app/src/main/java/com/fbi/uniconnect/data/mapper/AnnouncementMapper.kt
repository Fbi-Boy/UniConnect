package com.fbi.uniconnect.data.mapper

import com.fbi.uniconnect.data.model.Announcement as AnnouncementData
import com.fbi.uniconnect.domain.model.Announcement as AnnouncementDomain
import com.fbi.uniconnect.domain.model.AnnouncementCategory

fun AnnouncementData.toDomain(): AnnouncementDomain = AnnouncementDomain(
    id = id,
    title = title,
    content = content,
    publisher = publisher,
    publishedAt = publishedAt,
    category = AnnouncementCategory.valueOf(category),
)
