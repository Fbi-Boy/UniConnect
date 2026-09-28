package com.fbi.uniconnect.presentation.grades

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fbi.uniconnect.domain.model.Grade
import com.fbi.uniconnect.domain.usecase.grades.GetGradesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class GradeUiState(
    val isLoading: Boolean = true,
    val grades: List<Grade> = emptyList(),
    val errorMessage: String? = null,
)

@HiltViewModel
class GradeViewModel @Inject constructor(
    private val getGrades: GetGradesUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(GradeUiState())
    val uiState: StateFlow<GradeUiState> = _uiState.asStateFlow()

    init {
        loadGrades()
    }

    fun loadGrades() {
        viewModelScope.launch {
            _uiState.value = GradeUiState(isLoading = true)
            runCatching { getGrades() }
                .onSuccess { data ->
                    _uiState.value = GradeUiState(
                        isLoading = false,
                        grades = data,
                    )
                }
                .onFailure { error ->
                    _uiState.value = GradeUiState(
                        isLoading = false,
                        errorMessage = error.message ?: "Data nilai gagal dimuat.",
                    )
                }
        }
    }
}