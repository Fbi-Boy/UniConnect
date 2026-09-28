package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.data.model.Admin
import javax.inject.Inject

class AdminLocalDataSource @Inject constructor() {
    fun getCurrentAdmin(): Admin = Admin(
        id = "admin-001",
        name = "Admin UniConnect",
        email = "admin@uniconnect.app",
    )
}
