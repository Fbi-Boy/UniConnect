package com.fbi.uniconnect.presentation.attendance

import com.fbi.uniconnect.MainDispatcherRule

import com.fbi.uniconnect.domain.model.Attendance
import com.fbi.uniconnect.domain.model.AttendanceStatus
import com.fbi.uniconnect.domain.repository.AttendanceRepository
import com.fbi.uniconnect.domain.usecase.attendance.GetAttendancesUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Rule
import org.junit.Test

class AttendanceViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun loads_attendances_into_ui_state() {
        val expected = listOf(
            Attendance(
                id = "1",
                courseName = "Pemrograman Mobile",
                date = "28 September 2026",
                status = AttendanceStatus.PRESENT,
            ),
        )
        val repository = object : AttendanceRepository {
            override suspend fun getAttendances(): List<Attendance> = expected
        }

        val viewModel = AttendanceViewModel(GetAttendancesUseCase(repository))

        assertFalse(viewModel.uiState.value.isLoading)
        assertEquals(expected, viewModel.uiState.value.attendances)
    }
}