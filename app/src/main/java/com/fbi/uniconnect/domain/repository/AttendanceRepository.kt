package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.Attendance

interface AttendanceRepository {
    fun getAttendances(): List<Attendance>
}