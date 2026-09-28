package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.Assignment

interface AssignmentRepository {
    fun getAssignments(): List<Assignment>
}
