package com.fbi.uniconnect.data.remote

import retrofit2.http.GET

interface UniConnectApi {
    @GET("health")
    suspend fun health(): HealthResponse

    @GET("api/v1/schedules")
    suspend fun getSchedules(): List<ScheduleDto>

    @GET("api/v1/attendance")
    suspend fun getAttendance(): List<AttendanceDto>

    @GET("api/v1/grades")
    suspend fun getGrades(): List<GradeDto>

    @GET("api/v1/krs")
    suspend fun getKrs(): List<KrsDto>

    @GET("api/v1/assignments")
    suspend fun getAssignments(): List<AssignmentDto>

    @GET("api/v1/announcements")
    suspend fun getAnnouncements(): List<AnnouncementDto>
}
