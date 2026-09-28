package com.fbi.uniconnect.domain.usecase.announcement

import com.fbi.uniconnect.domain.model.Announcement
import com.fbi.uniconnect.domain.repository.AnnouncementRepository
import javax.inject.Inject

class GetAnnouncementsUseCase @Inject constructor(
    private val repository: AnnouncementRepository,
) {
    operator fun invoke(): List<Announcement> = repository.getAnnouncements()
}
