package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.core.database.KrsDao
import com.fbi.uniconnect.core.database.toDataModel
import com.fbi.uniconnect.core.database.toEntity
import com.fbi.uniconnect.data.model.Krs
import com.fbi.uniconnect.domain.model.KrsStatus
import javax.inject.Inject

class KrsLocalDataSource @Inject constructor(
    private val dao: KrsDao,
) {
    suspend fun getKrs(): List<Krs> {
        val cached = dao.getAll()
        if (cached.isNotEmpty()) return cached.map { it.toDataModel() }

        return defaultKrs().also { dao.insertAll(it.map { item -> item.toEntity() }) }
    }

    private fun defaultKrs() = listOf(
        Krs("krs-001", "Pemrograman Mobile", "TIF301", 3, "Budi Santoso, M.Kom.", KrsStatus.APPROVED),
        Krs("krs-002", "Basis Data", "TIF302", 3, "Siti Aminah, M.Kom.", KrsStatus.APPROVED),
        Krs("krs-003", "Statistika", "TIF303", 3, "Andi Pratama, M.Si.", KrsStatus.ENROLLED),
        Krs("krs-004", "Rekayasa Perangkat Lunak", "TIF304", 3, "Rina Lestari, M.Kom.", KrsStatus.ENROLLED),
        Krs("krs-005", "Kewirausahaan", "TIF305", 2, "Dewi Kartika, M.M.", KrsStatus.ENROLLED),
    )
}
