package com.fbi.uniconnect.data.remote

import com.fbi.uniconnect.core.network.NetworkResult
import com.fbi.uniconnect.core.network.safeApiCall
import com.fbi.uniconnect.data.model.CourseSchedule
import javax.inject.Inject

class AcademicRemoteDataSource @Inject constructor(
    private val api: UniConnectApi,
) {
    suspend fun getSchedules(): NetworkResult<List<CourseSchedule>> =
        when (val result = safeApiCall { api.getSchedules() }) {
            is NetworkResult.Success -> NetworkResult.Success(result.data.map(ScheduleDto::toDataModel))
            is NetworkResult.HttpError -> result
            is NetworkResult.NetworkError -> result
        }
}
