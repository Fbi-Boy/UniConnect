package com.fbi.uniconnect.di

import com.fbi.uniconnect.data.repository.AnnouncementRepositoryImpl
import com.fbi.uniconnect.domain.repository.AnnouncementRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AnnouncementModule {
    @Binds
    @Singleton
    abstract fun bindAnnouncementRepository(
        implementation: AnnouncementRepositoryImpl,
    ): AnnouncementRepository
}
