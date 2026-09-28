package com.fbi.uniconnect.presentation.student

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fbi.uniconnect.domain.model.Student
import com.fbi.uniconnect.domain.usecase.student.GetCurrentStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class StudentUiState(
    val isLoading: Boolean = true,
    val student: Student? = null,
    val errorMessage: String? = null,
)

@HiltViewModel
class StudentViewModel @Inject constructor(
    private val getCurrentStudent: GetCurrentStudentUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(StudentUiState())
    val uiState: StateFlow<StudentUiState> = _uiState.asStateFlow()

    init { loadStudent() }

    fun loadStudent() {
        viewModelScope.launch {
            _uiState.value = StudentUiState(isLoading = true)
            runCatching { getCurrentStudent() }
                .onSuccess { student ->
                    _uiState.value = StudentUiState(isLoading = false, student = student)
                }
                .onFailure { error ->
                    _uiState.value = StudentUiState(
                        isLoading = false,
                        errorMessage = error.message ?: "Data mahasiswa gagal dimuat.",
                    )
                }
        }
    }
}
