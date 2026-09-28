package com.fbi.uniconnect.presentation.student

import com.fbi.uniconnect.MainDispatcherRule

import com.fbi.uniconnect.domain.model.Student
import com.fbi.uniconnect.domain.repository.StudentRepository
import com.fbi.uniconnect.domain.usecase.student.GetCurrentStudentUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test

class StudentViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun loads_current_student_into_ui_state() {
        val expected = Student("student-001", "Fabi", "12345", "Teknologi Informasi", 3, 3.72)
        val repository = object : StudentRepository {
            override suspend fun getCurrentStudent(): Student = expected
        }

        val viewModel = StudentViewModel(GetCurrentStudentUseCase(repository))

        assertFalse(viewModel.uiState.value.isLoading)
        assertEquals(expected, viewModel.uiState.value.student)
        assertNull(viewModel.uiState.value.errorMessage)
    }
}
