package com.fbi.uniconnect.di
import com.fbi.uniconnect.data.repository.GradeRepositoryImpl
import com.fbi.uniconnect.domain.repository.GradeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module @InstallIn(SingletonComponent::class) abstract class GradeModule{@Binds @Singleton abstract fun bindGradeRepository(implementation:GradeRepositoryImpl):GradeRepository}