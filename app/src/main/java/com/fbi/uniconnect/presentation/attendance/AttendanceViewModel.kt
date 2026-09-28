package com.fbi.uniconnect.presentation.attendance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fbi.uniconnect.domain.model.Attendance
import com.fbi.uniconnect.domain.usecase.attendance.GetAttendancesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class AttendanceUiState(
    val isLoading: Boolean = true,
    val attendances: List<Attendance> = emptyList(),
    val errorMessage: String? = null,
)

@HiltViewModel
class AttendanceViewModel @Inject constructor(
    private val getAttendances: GetAttendancesUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AttendanceUiState())
    val uiState: StateFlow<AttendanceUiState> = _uiState.asStateFlow()

    init {
        loadAttendances()
    }

    fun loadAttendances() {
        viewModelScope.launch {
            _uiState.value = AttendanceUiState(isLoading = true)
            runCatching { getAttendances() }
                .onSuccess { data ->
                    _uiState.value = AttendanceUiState(isLoading = false, attendances = data)
                }
                .onFailure { error ->
                    _uiState.value = AttendanceUiState(
                        isLoading = false,
                        errorMessage = error.message ?: "Data kehadiran gagal dimuat.",
                    )
                }
        }
    }
}