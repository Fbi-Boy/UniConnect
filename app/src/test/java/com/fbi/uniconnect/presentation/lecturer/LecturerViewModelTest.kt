package com.fbi.uniconnect.presentation.lecturer

import com.fbi.uniconnect.MainDispatcherRule

import com.fbi.uniconnect.domain.model.Lecturer
import com.fbi.uniconnect.domain.repository.LecturerRepository
import com.fbi.uniconnect.domain.usecase.lecturer.GetCurrentLecturerUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Rule
import org.junit.Test

class LecturerViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun loads_current_lecturer_into_ui_state() {
        val expected = Lecturer(
            id = "lecturer-001",
            name = "Fabi",
            nidn = "12345",
            department = "Teknologi Informasi",
            email = "fabi@example.com",
        )
        val repository = object : LecturerRepository {
            override suspend fun getCurrentLecturer(): Lecturer = expected
        }

        val viewModel = LecturerViewModel(GetCurrentLecturerUseCase(repository))

        assertFalse(viewModel.uiState.value.isLoading)
        assertEquals(expected, viewModel.uiState.value.lecturer)
    }
}
