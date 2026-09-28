package com.fbi.uniconnect.domain.usecase.schedule

import com.fbi.uniconnect.domain.model.CourseSchedule
import com.fbi.uniconnect.domain.repository.ScheduleRepository
import javax.inject.Inject

class GetSchedulesUseCase @Inject constructor(
    private val repository: ScheduleRepository,
) {
    suspend operator fun invoke(): List<CourseSchedule> = repository.getSchedules()
}