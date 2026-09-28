package com.fbi.uniconnect.data.repository

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AuthRepositoryImplTest {
    @Test
    fun login_accepts_demo_credentials() {
        val repository = AuthRepositoryImpl()

        val result = repository.login("student@uniconnect.app", "password")

        assertTrue(result.isSuccess)
        assertEquals("student@uniconnect.app", result.getOrNull()?.email)
    }

    @Test
    fun login_rejects_invalid_password() {
        val repository = AuthRepositoryImpl()

        val result = repository.login("student@uniconnect.app", "wrong")

        assertTrue(result.isFailure)
    }

    @Test
    fun register_creates_student_session() {
        val repository = AuthRepositoryImpl()

        val result = repository.register(
            name = "Fabi",
            email = "fabi@example.com",
            password = "secret123",
        )

        assertTrue(result.isSuccess)
        assertEquals("Fabi", repository.getCurrentUser()?.name)
    }
}
