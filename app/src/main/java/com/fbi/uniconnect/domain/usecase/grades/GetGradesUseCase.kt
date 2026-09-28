package com.fbi.uniconnect.domain.usecase.grades

import com.fbi.uniconnect.domain.model.Grade
import com.fbi.uniconnect.domain.repository.GradeRepository
import javax.inject.Inject

class GetGradesUseCase @Inject constructor(
    private val repository: GradeRepository,
) {
    operator fun invoke(): List<Grade> = repository.getGrades()
}