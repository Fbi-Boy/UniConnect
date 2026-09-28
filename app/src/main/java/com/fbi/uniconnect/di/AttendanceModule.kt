package com.fbi.uniconnect.di

import com.fbi.uniconnect.data.repository.AttendanceRepositoryImpl
import com.fbi.uniconnect.domain.repository.AttendanceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AttendanceModule {
    @Binds
    @Singleton
    abstract fun bindAttendanceRepository(
        implementation: AttendanceRepositoryImpl,
    ): AttendanceRepository
}