package com.fbi.uniconnect.di

import com.fbi.uniconnect.data.repository.AdminRepositoryImpl
import com.fbi.uniconnect.domain.repository.AdminRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AdminModule {
    @Binds
    @Singleton
    abstract fun bindAdminRepository(
        implementation: AdminRepositoryImpl,
    ): AdminRepository
}
