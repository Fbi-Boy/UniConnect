package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.CourseSchedule

interface ScheduleRepository {
    suspend fun getSchedules(): List<CourseSchedule>
}
