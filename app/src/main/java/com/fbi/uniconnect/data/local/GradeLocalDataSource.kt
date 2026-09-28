package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.core.database.GradeDao
import com.fbi.uniconnect.core.database.toDataModel
import com.fbi.uniconnect.core.database.toEntity
import com.fbi.uniconnect.data.model.Grade
import com.fbi.uniconnect.domain.model.GradeLetter
import javax.inject.Inject

class GradeLocalDataSource @Inject constructor(
    private val dao: GradeDao,
) {
    suspend fun getGrades(): List<Grade> {
        val cached = dao.getAll()
        if (cached.isNotEmpty()) return cached.map { it.toDataModel() }

        return defaultGrades().also { dao.insertAll(it.map { item -> item.toEntity() }) }
    }

    private fun defaultGrades() = listOf(
        Grade("grade-001", "Pemrograman Mobile", 3, 92.0, GradeLetter.A),
        Grade("grade-002", "Basis Data", 3, 86.0, GradeLetter.AB),
        Grade("grade-003", "Statistika", 3, 81.0, GradeLetter.AB),
        Grade("grade-004", "Rekayasa Perangkat Lunak", 3, 88.0, GradeLetter.AB),
        Grade("grade-005", "Kewirausahaan", 2, 78.0, GradeLetter.B),
    )
}
