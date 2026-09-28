package com.fbi.uniconnect.domain.model

data class AuthUser(
    val id: String,
    val name: String,
    val email: String,
    val role: UserRole,
)

enum class UserRole {
    STUDENT,
    LECTURER,
    ADMIN,
}
