package com.fbi.uniconnect.domain.usecase.auth

import com.fbi.uniconnect.domain.model.UserRole
import org.junit.Assert.assertEquals
import org.junit.Test

class GetHomeRouteUseCaseTest {
    private val useCase = GetHomeRouteUseCase()

    @Test
    fun student_goes_to_student_dashboard() {
        assertEquals("dashboard", useCase(UserRole.STUDENT))
    }

    @Test
    fun lecturer_goes_to_lecturer_dashboard() {
        assertEquals("lecturer-dashboard", useCase(UserRole.LECTURER))
    }

    @Test
    fun admin_goes_to_admin_dashboard() {
        assertEquals("admin-dashboard", useCase(UserRole.ADMIN))
    }
}
