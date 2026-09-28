package com.fbi.uniconnect.presentation.assignments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fbi.uniconnect.domain.model.Assignment
import com.fbi.uniconnect.domain.usecase.assignment.GetAssignmentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class AssignmentUiState(
    val isLoading: Boolean = true,
    val assignments: List<Assignment> = emptyList(),
    val errorMessage: String? = null,
)

@HiltViewModel
class AssignmentViewModel @Inject constructor(
    private val getAssignmentsUseCase: GetAssignmentsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AssignmentUiState())
    val uiState: StateFlow<AssignmentUiState> = _uiState.asStateFlow()

    init {
        loadAssignments()
    }

    private fun loadAssignments() {
        viewModelScope.launch {
            runCatching { getAssignmentsUseCase() }
                .onSuccess { _uiState.value = AssignmentUiState(false, it) }
                .onFailure { _uiState.value = AssignmentUiState(false, emptyList(), it.message) }
        }
    }
}
