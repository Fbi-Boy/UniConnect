package com.fbi.uniconnect.data.repository

import com.fbi.uniconnect.data.local.AnnouncementLocalDataSource
import com.fbi.uniconnect.data.mapper.toDomain
import com.fbi.uniconnect.domain.model.Announcement
import com.fbi.uniconnect.domain.repository.AnnouncementRepository
import javax.inject.Inject

class AnnouncementRepositoryImpl @Inject constructor(
    private val localDataSource: AnnouncementLocalDataSource,
) : AnnouncementRepository {
    override suspend fun getAnnouncements(): List<Announcement> =
        localDataSource.getAnnouncements().map { it.toDomain() }
}