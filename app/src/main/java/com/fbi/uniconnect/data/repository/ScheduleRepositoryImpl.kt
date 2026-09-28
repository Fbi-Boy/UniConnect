package com.fbi.uniconnect.data.repository
import com.fbi.uniconnect.data.local.ScheduleLocalDataSource
import com.fbi.uniconnect.data.mapper.toDomain
import com.fbi.uniconnect.domain.model.CourseSchedule
import com.fbi.uniconnect.domain.repository.ScheduleRepository
import javax.inject.Inject
import javax.inject.Singleton
@Singleton class ScheduleRepositoryImpl @Inject constructor(private val local:ScheduleLocalDataSource):ScheduleRepository{
override fun getSchedules():List<CourseSchedule> = local.getSchedules().map{it.toDomain()}}