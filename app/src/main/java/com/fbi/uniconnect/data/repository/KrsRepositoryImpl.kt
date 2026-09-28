package com.fbi.uniconnect.data.repository
import com.fbi.uniconnect.data.local.KrsLocalDataSource
import com.fbi.uniconnect.data.mapper.toDomain
import com.fbi.uniconnect.domain.model.Krs
import com.fbi.uniconnect.domain.repository.KrsRepository
import javax.inject.Inject
import javax.inject.Singleton
@Singleton class KrsRepositoryImpl @Inject constructor(private val localDataSource:KrsLocalDataSource):KrsRepository{
override fun getKrs():List<Krs>=localDataSource.getKrs().map{it.toDomain()}}