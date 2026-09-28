package com.fbi.uniconnect.data.remote

import com.fbi.uniconnect.core.network.NetworkResult
import com.fbi.uniconnect.core.network.safeApiCall
import com.fbi.uniconnect.data.model.Announcement
import com.fbi.uniconnect.data.model.Assignment
import com.fbi.uniconnect.data.model.Attendance
import com.fbi.uniconnect.data.model.CourseSchedule
import com.fbi.uniconnect.data.model.Grade
import com.fbi.uniconnect.data.model.Krs
import javax.inject.Inject

interface AcademicRemoteSource {
    suspend fun getSchedules(): NetworkResult<List<CourseSchedule>>
    suspend fun getAttendances(): NetworkResult<List<Attendance>>
    suspend fun getGrades(): NetworkResult<List<Grade>>
    suspend fun getKrs(): NetworkResult<List<Krs>>
    suspend fun getAssignments(): NetworkResult<List<Assignment>>
    suspend fun getAnnouncements(): NetworkResult<List<Announcement>>
}

class AcademicRemoteDataSource @Inject constructor(
    private val api: UniConnectApi,
) : AcademicRemoteSource {
    override suspend fun getSchedules(): NetworkResult<List<CourseSchedule>> =
        safeApiCall { api.getSchedules() }.mapData { items -> items.map(ScheduleDto::toDataModel) }

    override suspend fun getAttendances(): NetworkResult<List<Attendance>> =
        safeApiCall { api.getAttendance() }.mapData { items -> items.map(AttendanceDto::toDataModel) }

    override suspend fun getGrades(): NetworkResult<List<Grade>> =
        safeApiCall { api.getGrades() }.mapData { items -> items.map(GradeDto::toDataModel) }

    override suspend fun getKrs(): NetworkResult<List<Krs>> =
        safeApiCall { api.getKrs() }.mapData { items -> items.map(KrsDto::toDataModel) }

    override suspend fun getAssignments(): NetworkResult<List<Assignment>> =
        safeApiCall { api.getAssignments() }.mapData { items -> items.map(AssignmentDto::toDataModel) }

    override suspend fun getAnnouncements(): NetworkResult<List<Announcement>> =
        safeApiCall { api.getAnnouncements() }.mapData { items -> items.map(AnnouncementDto::toDataModel) }
}

private inline fun <T, R> NetworkResult<T>.mapData(transform: (T) -> R): NetworkResult<R> =
    when (this) {
        is NetworkResult.Success -> NetworkResult.Success(transform(data))
        is NetworkResult.HttpError -> this
        is NetworkResult.NetworkError -> this
    }
