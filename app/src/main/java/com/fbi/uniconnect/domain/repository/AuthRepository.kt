package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.AuthUser

interface AuthRepository {
    fun login(email: String, password: String): Result<AuthUser>
    fun register(name: String, email: String, password: String): Result<AuthUser>
    fun getCurrentUser(): AuthUser?
    fun logout()
}
