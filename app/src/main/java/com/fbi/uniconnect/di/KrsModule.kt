package com.fbi.uniconnect.di
import com.fbi.uniconnect.data.repository.KrsRepositoryImpl
import com.fbi.uniconnect.domain.repository.KrsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module @InstallIn(SingletonComponent::class) abstract class KrsModule{@Binds @Singleton abstract fun bindKrsRepository(implementation:KrsRepositoryImpl):KrsRepository}