package com.fbi.uniconnect.domain.usecase.student

import com.fbi.uniconnect.domain.model.Student
import com.fbi.uniconnect.domain.repository.StudentRepository
import javax.inject.Inject

class GetCurrentStudentUseCase @Inject constructor(
    private val repository: StudentRepository,
) {
    suspend operator fun invoke(): Student = repository.getCurrentStudent()
}