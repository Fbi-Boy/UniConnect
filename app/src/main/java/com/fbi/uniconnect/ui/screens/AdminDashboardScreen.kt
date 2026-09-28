package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fbi.uniconnect.domain.model.Admin
import com.fbi.uniconnect.presentation.admin.AdminViewModel
import com.fbi.uniconnect.ui.components.UniConnectAvatar
import com.fbi.uniconnect.ui.components.UniConnectCard
import com.fbi.uniconnect.ui.components.UniConnectLoading
import com.fbi.uniconnect.ui.components.UniConnectStatus
import com.fbi.uniconnect.ui.components.UniConnectStatusChip

@Composable
fun AdminDashboardScreen(viewModel: AdminViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    when {
        state.isLoading -> UniConnectLoading()
        state.errorMessage != null -> Text(
            text = state.errorMessage ?: "Data admin gagal dimuat.",
            modifier = Modifier.padding(20.dp),
            color = MaterialTheme.colorScheme.error,
        )
        state.admin != null -> AdminDashboardContent(state.admin!!)
    }
}

@Composable
private fun AdminDashboardContent(admin: Admin) {
    val initials = admin.name.split(" ").filter(String::isNotBlank).take(2)
        .joinToString("") { it.first().toString() }
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text("Dashboard Admin", style = MaterialTheme.typography.headlineSmall)
        UniConnectCard {
            UniConnectAvatar(initials = initials)
            Text(admin.name, style = MaterialTheme.typography.titleLarge)
            Text(admin.email, style = MaterialTheme.typography.bodyMedium)
            UniConnectStatusChip(text = "Administrator", status = UniConnectStatus.INFO)
        }
        UniConnectCard {
            Text("Administrasi Kampus", style = MaterialTheme.typography.titleMedium)
            Text("Kelola pengguna, data akademik, pengumuman, dan konfigurasi UniConnect.")
        }
    }
}
