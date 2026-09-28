package com.fbi.uniconnect.domain.usecase.attendance

import com.fbi.uniconnect.domain.model.Attendance
import com.fbi.uniconnect.domain.repository.AttendanceRepository
import javax.inject.Inject

class GetAttendancesUseCase @Inject constructor(
    private val repository: AttendanceRepository,
) {
    operator fun invoke(): List<Attendance> = repository.getAttendances()
}