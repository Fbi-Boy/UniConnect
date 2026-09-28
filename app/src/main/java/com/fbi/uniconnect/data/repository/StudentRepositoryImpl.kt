package com.fbi.uniconnect.data.repository

import com.fbi.uniconnect.data.local.StudentLocalDataSource
import com.fbi.uniconnect.data.mapper.toDomain
import com.fbi.uniconnect.domain.model.Student
import com.fbi.uniconnect.domain.repository.StudentRepository
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val localDataSource: StudentLocalDataSource,
) : StudentRepository {
    override fun getCurrentStudent(): Student =
        localDataSource.getCurrentStudent().toDomain()
}
