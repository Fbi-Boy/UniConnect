package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.core.database.AdminDao
import com.fbi.uniconnect.core.database.toDataModel
import com.fbi.uniconnect.core.database.toEntity
import com.fbi.uniconnect.data.model.Admin
import javax.inject.Inject

class AdminLocalDataSource @Inject constructor(
    private val dao: AdminDao,
) {
    suspend fun getCurrentAdmin(): Admin {
        return dao.getCurrent()?.toDataModel() ?: Admin(
            id = "admin-001",
            name = "Admin UniConnect",
            email = "admin@uniconnect.app",
        ).also { dao.insert(it.toEntity()) }
    }
}
