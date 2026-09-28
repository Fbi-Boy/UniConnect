package com.fbi.uniconnect.presentation.assignments

import com.fbi.uniconnect.domain.model.Assignment
import com.fbi.uniconnect.domain.model.AssignmentStatus
import com.fbi.uniconnect.domain.repository.AssignmentRepository
import com.fbi.uniconnect.domain.usecase.assignment.GetAssignmentsUseCase
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AssignmentViewModelTest {
    @Test
    fun loadsAssignmentsIntoUiState() = runTest(StandardTestDispatcher()) {
        val repository = object : AssignmentRepository {
            override suspend fun getAssignments(): List<Assignment> = listOf(
                Assignment(
                    "1", "Tugas", "Pemrograman Mobile", "Deskripsi",
                    "30 September 2026", "23:59", AssignmentStatus.PENDING,
                ),
            )
        }
        val viewModel = AssignmentViewModel(GetAssignmentsUseCase(repository))
        assertEquals(1, viewModel.uiState.value.assignments.size)
    }
}
