package com.fbi.uniconnect.presentation.krs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fbi.uniconnect.domain.model.Krs
import com.fbi.uniconnect.domain.usecase.krs.GetKrsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class KrsUiState(
    val isLoading: Boolean = true,
    val courses: List<Krs> = emptyList(),
    val errorMessage: String? = null,
)

@HiltViewModel
class KrsViewModel @Inject constructor(
    private val getKrs: GetKrsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(KrsUiState())
    val uiState: StateFlow<KrsUiState> = _uiState.asStateFlow()

    init {
        loadKrs()
    }

    fun loadKrs() {
        viewModelScope.launch {
            _uiState.value = KrsUiState(isLoading = true)
            runCatching { getKrs() }
                .onSuccess { data ->
                    _uiState.value = KrsUiState(
                        isLoading = false,
                        courses = data,
                    )
                }
                .onFailure { error ->
                    _uiState.value = KrsUiState(
                        isLoading = false,
                        errorMessage = error.message ?: "Data KRS gagal dimuat.",
                    )
                }
        }
    }
}