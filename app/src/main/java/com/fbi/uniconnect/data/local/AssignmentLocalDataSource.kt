package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.data.model.Assignment
import javax.inject.Inject

class AssignmentLocalDataSource @Inject constructor() {
    fun getAssignments(): List<Assignment> = listOf(
        Assignment("assignment-001", "Implementasi Navigation Compose", "Pemrograman Mobile", "Buat alur navigasi multi-screen menggunakan Navigation Compose.", "30 September 2026", "23:59", "PENDING"),
        Assignment("assignment-002", "Normalisasi Database", "Basis Data", "Normalisasikan studi kasus sampai bentuk normal ketiga.", "2 Oktober 2026", "20:00", "PENDING"),
        Assignment("assignment-003", "Analisis Data Kelompok", "Statistika", "Hitung kuartil dan percentile rank dari data kelompok.", "25 September 2026", "23:59", "OVERDUE"),
        Assignment("assignment-004", "Dokumentasi Sprint", "Rekayasa Perangkat Lunak", "Susun dokumentasi hasil pengembangan fitur aplikasi.", "5 Oktober 2026", "21:00", "SUBMITTED"),
    )
}
