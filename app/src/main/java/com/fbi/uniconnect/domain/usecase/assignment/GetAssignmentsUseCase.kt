package com.fbi.uniconnect.domain.usecase.assignment

import com.fbi.uniconnect.domain.model.Assignment
import com.fbi.uniconnect.domain.repository.AssignmentRepository
import javax.inject.Inject

class GetAssignmentsUseCase @Inject constructor(
    private val repository: AssignmentRepository,
) {
    operator fun invoke(): List<Assignment> = repository.getAssignments()
}
