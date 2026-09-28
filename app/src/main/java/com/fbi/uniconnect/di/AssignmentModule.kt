package com.fbi.uniconnect.di

import com.fbi.uniconnect.data.repository.AssignmentRepositoryImpl
import com.fbi.uniconnect.domain.repository.AssignmentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AssignmentModule {
    @Binds
    @Singleton
    abstract fun bindAssignmentRepository(
        implementation: AssignmentRepositoryImpl,
    ): AssignmentRepository
}
