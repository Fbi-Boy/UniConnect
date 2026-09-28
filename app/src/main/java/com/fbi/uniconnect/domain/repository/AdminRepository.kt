package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.Admin

interface AdminRepository {
    fun getCurrentAdmin(): Admin
}
