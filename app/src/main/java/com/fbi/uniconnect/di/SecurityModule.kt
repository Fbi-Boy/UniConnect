package com.fbi.uniconnect.di

import com.fbi.uniconnect.core.security.InMemorySessionStore
import com.fbi.uniconnect.core.security.SessionStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SecurityModule {
    @Binds
    @Singleton
    abstract fun bindSessionStore(
        implementation: InMemorySessionStore,
    ): SessionStore
}
