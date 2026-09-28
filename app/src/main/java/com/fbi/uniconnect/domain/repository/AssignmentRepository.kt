package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.Assignment

interface AssignmentRepository {
    suspend fun getAssignments(): List<Assignment>
}
