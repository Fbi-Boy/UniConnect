package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fbi.uniconnect.presentation.auth.AuthViewModel
import com.fbi.uniconnect.ui.components.UniConnectPrimaryButton
import com.fbi.uniconnect.ui.components.UniConnectSecondaryButton
import com.fbi.uniconnect.ui.components.UniConnectTextField
import com.fbi.uniconnect.ui.theme.UniConnectSpacing

@Composable
fun RegisterScreen(
    onRegister: () -> Unit,
    onBackToLogin: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel(),
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(UniConnectSpacing.xxl),
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Buat akun mahasiswa")
        Spacer(Modifier.height(UniConnectSpacing.lg))

        UniConnectTextField(
            value = name,
            onValueChange = {
                name = it
                viewModel.clearError()
            },
            label = "Nama lengkap",
        )

        Spacer(Modifier.height(UniConnectSpacing.sm))

        UniConnectTextField(
            value = email,
            onValueChange = {
                email = it
                viewModel.clearError()
            },
            label = "Email",
        )

        Spacer(Modifier.height(UniConnectSpacing.sm))

        UniConnectTextField(
            value = password,
            onValueChange = {
                password = it
                viewModel.clearError()
            },
            label = "Password",
            singleLine = true,
        )

        Spacer(Modifier.height(UniConnectSpacing.lg))

        uiState.errorMessage?.let {
            Text(it)
            Spacer(Modifier.height(UniConnectSpacing.sm))
        }

        UniConnectPrimaryButton(
            text = "Daftar",
            enabled = !uiState.isLoading,
            onClick = {
                viewModel.register(name, email, password, onRegister)
            },
        )

        Spacer(Modifier.height(UniConnectSpacing.sm))

        UniConnectSecondaryButton(
            text = "Kembali ke login",
            enabled = !uiState.isLoading,
            onClick = onBackToLogin,
        )

        if (uiState.isLoading) {
            Spacer(Modifier.height(UniConnectSpacing.lg))
            CircularProgressIndicator()
        }
    }
}
