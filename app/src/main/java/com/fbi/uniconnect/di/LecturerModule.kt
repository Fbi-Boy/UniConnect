package com.fbi.uniconnect.di

import com.fbi.uniconnect.data.repository.LecturerRepositoryImpl
import com.fbi.uniconnect.domain.repository.LecturerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LecturerModule {
    @Binds
    @Singleton
    abstract fun bindLecturerRepository(
        implementation: LecturerRepositoryImpl,
    ): LecturerRepository
}
