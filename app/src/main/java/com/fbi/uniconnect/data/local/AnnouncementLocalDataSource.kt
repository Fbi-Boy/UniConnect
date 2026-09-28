package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.core.database.AnnouncementDao
import com.fbi.uniconnect.core.database.toDataModel
import com.fbi.uniconnect.core.database.toEntity
import com.fbi.uniconnect.data.model.Announcement
import javax.inject.Inject

class AnnouncementLocalDataSource @Inject constructor(
    private val dao: AnnouncementDao,
) {
    suspend fun getAnnouncements(): List<Announcement> {
        val cached = dao.getAll()
        if (cached.isNotEmpty()) return cached.map { it.toDataModel() }

        return defaultAnnouncements().also { dao.insertAll(it.map { item -> item.toEntity() }) }
    }

    private fun defaultAnnouncements() = listOf(
        Announcement("announcement-001", "Jadwal Ujian Tengah Semester", "Jadwal UTS semester ganjil telah diterbitkan. Silakan cek jadwal masing-masing mata kuliah.", "Akademik", "28 September 2026", "ACADEMIC"),
        Announcement("announcement-002", "Pemeliharaan Sistem Kampus", "Portal akademik akan mengalami pemeliharaan pada Sabtu pukul 22.00 sampai 24.00.", "UPT TIK", "27 September 2026", "SYSTEM"),
        Announcement("announcement-003", "Seminar Teknologi Informasi", "Pendaftaran seminar teknologi informasi dibuka untuk seluruh mahasiswa.", "BEM Kampus", "25 September 2026", "EVENT"),
        Announcement("announcement-004", "Program Beasiswa Mahasiswa", "Informasi pendaftaran dan persyaratan beasiswa tersedia di bagian akademik.", "Bagian Kemahasiswaan", "22 September 2026", "CAMPUS"),
    )
}
