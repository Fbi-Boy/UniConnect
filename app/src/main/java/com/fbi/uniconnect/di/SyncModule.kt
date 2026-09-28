package com.fbi.uniconnect.di

import com.fbi.uniconnect.data.remote.AcademicRemoteDataSource
import com.fbi.uniconnect.data.remote.AcademicRemoteSource
import com.fbi.uniconnect.data.sync.AcademicSyncStore
import com.fbi.uniconnect.data.sync.RoomAcademicSyncStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SyncModule {
    @Binds
    @Singleton
    abstract fun bindAcademicRemoteSource(source: AcademicRemoteDataSource): AcademicRemoteSource

    @Binds
    @Singleton
    abstract fun bindAcademicSyncStore(store: RoomAcademicSyncStore): AcademicSyncStore
}
