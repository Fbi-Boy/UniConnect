package com.fbi.uniconnect.presentation.auth

import androidx.lifecycle.ViewModel
import com.fbi.uniconnect.domain.model.AuthUser
import com.fbi.uniconnect.domain.usecase.auth.GetCurrentUserUseCase
import com.fbi.uniconnect.domain.usecase.auth.LoginUseCase
import com.fbi.uniconnect.domain.usecase.auth.LogoutUseCase
import com.fbi.uniconnect.domain.usecase.auth.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AuthUiState(
    val currentUser: AuthUser? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val logoutUseCase: LogoutUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        AuthUiState(currentUser = getCurrentUserUseCase()),
    )
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        if (email.isBlank() || password.isBlank()) {
            setError("Email dan password wajib diisi.")
            return
        }

        _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

        loginUseCase(email, password)
            .onSuccess {
                _uiState.value = AuthUiState(currentUser = it)
                onSuccess()
            }
            .onFailure {
                _uiState.value = AuthUiState(errorMessage = it.message)
            }
    }

    fun register(
        name: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
    ) {
        when {
            name.isBlank() -> setError("Nama lengkap wajib diisi.")
            email.isBlank() -> setError("Email wajib diisi.")
            !email.contains("@") -> setError("Format email tidak valid.")
            password.length < 6 -> setError("Password minimal 6 karakter.")
            else -> {
                _uiState.value = _uiState.value.copy(
                    isLoading = true,
                    errorMessage = null,
                )

                registerUseCase(name, email, password)
                    .onSuccess {
                        _uiState.value = AuthUiState(currentUser = it)
                        onSuccess()
                    }
                    .onFailure {
                        _uiState.value = AuthUiState(errorMessage = it.message)
                    }
            }
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(errorMessage = null)
    }

    fun logout() {
        logoutUseCase()
        _uiState.value = AuthUiState()
    }

    private fun setError(message: String) {
        _uiState.value = _uiState.value.copy(
            isLoading = false,
            errorMessage = message,
        )
    }
}
