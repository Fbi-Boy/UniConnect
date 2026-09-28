package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.Attendance

interface AttendanceRepository {
    suspend fun getAttendances(): List<Attendance>
}
