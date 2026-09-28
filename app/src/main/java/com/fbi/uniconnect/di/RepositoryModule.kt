package com.fbi.uniconnect.di

import com.fbi.uniconnect.data.repository.StudentRepositoryImpl
import com.fbi.uniconnect.domain.repository.StudentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindStudentRepository(
        implementation: StudentRepositoryImpl,
    ): StudentRepository
}
