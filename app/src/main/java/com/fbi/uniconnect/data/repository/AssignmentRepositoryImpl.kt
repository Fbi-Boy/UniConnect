package com.fbi.uniconnect.data.repository

import com.fbi.uniconnect.data.local.AssignmentLocalDataSource
import com.fbi.uniconnect.data.mapper.toDomain
import com.fbi.uniconnect.domain.model.Assignment
import com.fbi.uniconnect.domain.repository.AssignmentRepository
import javax.inject.Inject

class AssignmentRepositoryImpl @Inject constructor(
    private val localDataSource: AssignmentLocalDataSource,
) : AssignmentRepository {
    override suspend fun getAssignments(): List<Assignment> =
        localDataSource.getAssignments().map { it.toDomain() }
}