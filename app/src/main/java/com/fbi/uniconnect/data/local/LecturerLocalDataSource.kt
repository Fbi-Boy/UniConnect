package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.core.database.LecturerDao
import com.fbi.uniconnect.core.database.toDataModel
import com.fbi.uniconnect.core.database.toEntity
import com.fbi.uniconnect.data.model.Lecturer
import javax.inject.Inject

class LecturerLocalDataSource @Inject constructor(
    private val dao: LecturerDao,
) {
    suspend fun getCurrentLecturer(): Lecturer {
        return dao.getCurrent()?.toDataModel() ?: Lecturer(
            id = "lecturer-001",
            name = "Dosen UniConnect",
            nidn = "0000000000",
            department = "Teknologi Informasi",
            email = "lecturer@uniconnect.app",
        ).also { dao.insert(it.toEntity()) }
    }
}
