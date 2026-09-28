package com.fbi.uniconnect.data.repository

import com.fbi.uniconnect.domain.model.AuthUser
import com.fbi.uniconnect.domain.model.UserRole
import com.fbi.uniconnect.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    private val users = mutableListOf(
        AuthUser(
            id = "student-001",
            name = "Mahasiswa UniConnect",
            email = "student@uniconnect.app",
            role = UserRole.STUDENT,
        ),
    )

    private val passwords = mutableMapOf(
        "student@uniconnect.app" to "password",
    )

    private var currentUser: AuthUser? = null

    override fun login(email: String, password: String): Result<AuthUser> {
        val normalizedEmail = email.trim().lowercase()
        val user = users.firstOrNull { it.email == normalizedEmail }
            ?: return Result.failure(IllegalArgumentException("Email atau password salah."))

        if (passwords[normalizedEmail] != password) {
            return Result.failure(IllegalArgumentException("Email atau password salah."))
        }

        currentUser = user
        return Result.success(user)
    }

    override fun register(name: String, email: String, password: String): Result<AuthUser> {
        val normalizedEmail = email.trim().lowercase()

        if (users.any { it.email == normalizedEmail }) {
            return Result.failure(IllegalArgumentException("Email sudah terdaftar."))
        }

        val user = AuthUser(
            id = "student-" + (users.size + 1),
            name = name.trim(),
            email = normalizedEmail,
            role = UserRole.STUDENT,
        )

        users += user
        passwords[normalizedEmail] = password
        currentUser = user

        return Result.success(user)
    }

    override fun getCurrentUser(): AuthUser? = currentUser

    override fun logout() {
        currentUser = null
    }
}
