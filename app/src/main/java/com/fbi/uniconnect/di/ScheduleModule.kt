package com.fbi.uniconnect.di
import com.fbi.uniconnect.data.repository.ScheduleRepositoryImpl
import com.fbi.uniconnect.domain.repository.ScheduleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module @InstallIn(SingletonComponent::class) abstract class ScheduleModule{
@Binds @Singleton abstract fun bindScheduleRepository(implementation:ScheduleRepositoryImpl):ScheduleRepository}