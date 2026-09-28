package com.fbi.uniconnect.presentation.admin

import com.fbi.uniconnect.domain.model.Admin
import com.fbi.uniconnect.domain.repository.AdminRepository
import com.fbi.uniconnect.domain.usecase.admin.GetCurrentAdminUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class AdminViewModelTest {
    @Test
    fun loads_current_admin_into_ui_state() {
        val expected = Admin("admin-001", "Fabi", "admin@example.com")
        val repository = object : AdminRepository {
            override suspend fun getCurrentAdmin(): Admin = expected
        }
        val viewModel = AdminViewModel(GetCurrentAdminUseCase(repository))
        assertFalse(viewModel.uiState.value.isLoading)
        assertEquals(expected, viewModel.uiState.value.admin)
    }
}
