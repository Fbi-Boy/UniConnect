package com.fbi.uniconnect.domain.repository
import com.fbi.uniconnect.domain.model.CourseSchedule
interface ScheduleRepository { fun getSchedules(): List<CourseSchedule> }