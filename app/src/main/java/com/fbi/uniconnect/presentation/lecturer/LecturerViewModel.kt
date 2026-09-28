package com.fbi.uniconnect.presentation.lecturer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fbi.uniconnect.domain.model.Lecturer
import com.fbi.uniconnect.domain.usecase.lecturer.GetCurrentLecturerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class LecturerUiState(
    val isLoading: Boolean = true,
    val lecturer: Lecturer? = null,
    val errorMessage: String? = null,
)

@HiltViewModel
class LecturerViewModel @Inject constructor(
    private val getCurrentLecturer: GetCurrentLecturerUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LecturerUiState())
    val uiState: StateFlow<LecturerUiState> = _uiState.asStateFlow()

    init {
        loadLecturer()
    }

    fun loadLecturer() {
        viewModelScope.launch {
            _uiState.value = LecturerUiState(isLoading = true)
            runCatching { getCurrentLecturer() }
                .onSuccess { lecturer ->
                    _uiState.value = LecturerUiState(isLoading = false, lecturer = lecturer)
                }
                .onFailure { error ->
                    _uiState.value = LecturerUiState(
                        isLoading = false,
                        errorMessage = error.message ?: "Data dosen gagal dimuat.",
                    )
                }
        }
    }
}
