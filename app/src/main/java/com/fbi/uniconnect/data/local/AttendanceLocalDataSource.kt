package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.core.database.AttendanceDao
import com.fbi.uniconnect.core.database.toDataModel
import com.fbi.uniconnect.core.database.toEntity
import com.fbi.uniconnect.data.model.Attendance
import com.fbi.uniconnect.domain.model.AttendanceStatus
import javax.inject.Inject

class AttendanceLocalDataSource @Inject constructor(
    private val dao: AttendanceDao,
) {
    suspend fun getAttendances(): List<Attendance> {
        val cached = dao.getAll()
        if (cached.isNotEmpty()) return cached.map { it.toDataModel() }

        return defaultAttendances().also { dao.insertAll(it.map { item -> item.toEntity() }) }
    }

    private fun defaultAttendances() = listOf(
        Attendance("attendance-001", "Pemrograman Mobile", "22 September 2026", AttendanceStatus.PRESENT),
        Attendance("attendance-002", "Basis Data", "23 September 2026", AttendanceStatus.LATE, "Datang 10 menit terlambat"),
        Attendance("attendance-003", "Statistika", "24 September 2026", AttendanceStatus.PRESENT),
        Attendance("attendance-004", "Rekayasa Perangkat Lunak", "25 September 2026", AttendanceStatus.EXCUSED, "Surat izin"),
        Attendance("attendance-005", "Kewirausahaan", "26 September 2026", AttendanceStatus.ABSENT),
    )
}
