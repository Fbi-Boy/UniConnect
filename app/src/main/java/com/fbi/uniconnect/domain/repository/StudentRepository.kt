package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.Student

interface StudentRepository {
    suspend fun getCurrentStudent(): Student
}
