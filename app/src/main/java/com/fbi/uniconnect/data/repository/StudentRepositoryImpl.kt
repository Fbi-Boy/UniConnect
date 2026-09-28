package com.fbi.uniconnect.data.repository

import com.fbi.uniconnect.data.mapper.toDomain
import com.fbi.uniconnect.domain.model.Student
import com.fbi.uniconnect.domain.repository.StudentRepository
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor() : StudentRepository {
    override fun getCurrentStudent(): Student =
        StudentRepository().getCurrentStudent().toDomain()
}
