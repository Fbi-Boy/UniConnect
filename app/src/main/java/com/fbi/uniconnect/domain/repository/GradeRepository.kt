package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.Grade

interface GradeRepository {
    suspend fun getGrades(): List<Grade>
}
