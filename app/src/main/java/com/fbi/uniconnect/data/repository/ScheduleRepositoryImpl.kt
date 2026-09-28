package com.fbi.uniconnect.data.repository

import com.fbi.uniconnect.data.local.ScheduleLocalDataSource
import com.fbi.uniconnect.data.mapper.toDomain
import com.fbi.uniconnect.data.remote.AcademicRemoteDataSource
import com.fbi.uniconnect.core.network.NetworkResult
import com.fbi.uniconnect.domain.model.CourseSchedule
import com.fbi.uniconnect.domain.repository.ScheduleRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScheduleRepositoryImpl @Inject constructor(
    private val local: ScheduleLocalDataSource,
    private val remote: AcademicRemoteDataSource,
) : ScheduleRepository {
    override suspend fun getSchedules(): List<CourseSchedule> {
        return when (val result = remote.getSchedules()) {
            is NetworkResult.Success -> {
                if (result.data.isNotEmpty()) {
                    local.saveSchedules(result.data)
                    result.data.map { it.toDomain() }
                } else {
                    local.getSchedules().map { it.toDomain() }
                }
            }
            is NetworkResult.HttpError,
            is NetworkResult.NetworkError -> local.getSchedules().map { it.toDomain() }
        }
    }
}
