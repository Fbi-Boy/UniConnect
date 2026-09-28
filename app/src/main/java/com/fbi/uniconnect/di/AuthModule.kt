package com.fbi.uniconnect.di

import com.fbi.uniconnect.data.repository.AuthRepositoryImpl
import com.fbi.uniconnect.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        implementation: AuthRepositoryImpl,
    ): AuthRepository
}
