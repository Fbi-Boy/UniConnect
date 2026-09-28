package com.fbi.uniconnect.data.repository
import com.fbi.uniconnect.data.local.GradeLocalDataSource
import com.fbi.uniconnect.data.mapper.toDomain
import com.fbi.uniconnect.domain.model.Grade
import com.fbi.uniconnect.domain.repository.GradeRepository
import javax.inject.Inject
import javax.inject.Singleton
@Singleton class GradeRepositoryImpl @Inject constructor(private val localDataSource:GradeLocalDataSource):GradeRepository{
override fun getGrades():List<Grade>=localDataSource.getGrades().map{it.toDomain()}}