package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.core.database.AssignmentDao
import com.fbi.uniconnect.core.database.toDataModel
import com.fbi.uniconnect.core.database.toEntity
import com.fbi.uniconnect.data.model.Assignment
import javax.inject.Inject

class AssignmentLocalDataSource @Inject constructor(
    private val dao: AssignmentDao,
) {
    suspend fun getAssignments(): List<Assignment> {
        val cached = dao.getAll()
        if (cached.isNotEmpty()) return cached.map { it.toDataModel() }

        return defaultAssignments().also { dao.insertAll(it.map { item -> item.toEntity() }) }
    }

    private fun defaultAssignments() = listOf(
        Assignment("assignment-001", "Implementasi Navigation Compose", "Pemrograman Mobile", "Buat alur navigasi multi-screen menggunakan Navigation Compose.", "30 September 2026", "23:59", "PENDING"),
        Assignment("assignment-002", "Normalisasi Database", "Basis Data", "Normalisasikan studi kasus sampai bentuk normal ketiga.", "2 Oktober 2026", "20:00", "PENDING"),
        Assignment("assignment-003", "Analisis Data Kelompok", "Statistika", "Hitung kuartil dan percentile rank dari data kelompok.", "25 September 2026", "23:59", "OVERDUE"),
        Assignment("assignment-004", "Dokumentasi Sprint", "Rekayasa Perangkat Lunak", "Susun dokumentasi hasil pengembangan fitur aplikasi.", "5 Oktober 2026", "21:00", "SUBMITTED"),
    )
}
