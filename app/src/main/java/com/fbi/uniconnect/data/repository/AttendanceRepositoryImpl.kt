package com.fbi.uniconnect.data.repository

import com.fbi.uniconnect.data.local.AttendanceLocalDataSource
import com.fbi.uniconnect.data.mapper.toDomain
import com.fbi.uniconnect.domain.model.Attendance
import com.fbi.uniconnect.domain.repository.AttendanceRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AttendanceRepositoryImpl @Inject constructor(
    private val localDataSource: AttendanceLocalDataSource,
) : AttendanceRepository {
    override fun getAttendances(): List<Attendance> =
        localDataSource.getAttendances().map { it.toDomain() }
}