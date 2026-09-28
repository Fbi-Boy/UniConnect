package com.fbi.uniconnect.presentation.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fbi.uniconnect.domain.model.Admin
import com.fbi.uniconnect.domain.usecase.admin.GetCurrentAdminUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class AdminUiState(
    val isLoading: Boolean = true,
    val admin: Admin? = null,
    val errorMessage: String? = null,
)

@HiltViewModel
class AdminViewModel @Inject constructor(
    private val getCurrentAdmin: GetCurrentAdminUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AdminUiState())
    val uiState: StateFlow<AdminUiState> = _uiState.asStateFlow()

    init { loadAdmin() }

    fun loadAdmin() {
        viewModelScope.launch {
            _uiState.value = AdminUiState(isLoading = true)
            runCatching { getCurrentAdmin() }
                .onSuccess { admin -> _uiState.value = AdminUiState(false, admin) }
                .onFailure { error ->
                    _uiState.value = AdminUiState(
                        isLoading = false,
                        errorMessage = error.message ?: "Data admin gagal dimuat.",
                    )
                }
        }
    }
}
