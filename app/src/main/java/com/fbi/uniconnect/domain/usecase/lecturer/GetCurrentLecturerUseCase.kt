package com.fbi.uniconnect.domain.usecase.lecturer

import com.fbi.uniconnect.domain.model.Lecturer
import com.fbi.uniconnect.domain.repository.LecturerRepository
import javax.inject.Inject

class GetCurrentLecturerUseCase @Inject constructor(
    private val repository: LecturerRepository,
) {
    operator fun invoke(): Lecturer = repository.getCurrentLecturer()
}
