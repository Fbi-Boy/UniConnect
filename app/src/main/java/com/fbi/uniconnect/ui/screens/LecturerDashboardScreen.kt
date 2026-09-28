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
import com.fbi.uniconnect.domain.model.Lecturer
import com.fbi.uniconnect.presentation.lecturer.LecturerViewModel
import com.fbi.uniconnect.ui.components.UniConnectAvatar
import com.fbi.uniconnect.ui.components.UniConnectCard
import com.fbi.uniconnect.ui.components.UniConnectLoading
import com.fbi.uniconnect.ui.components.UniConnectStatus
import com.fbi.uniconnect.ui.components.UniConnectStatusChip

@Composable
fun LecturerDashboardScreen(
    viewModel: LecturerViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val lecturer = state.lecturer

    when {
        state.isLoading -> UniConnectLoading()
        state.errorMessage != null -> Text(
            text = state.errorMessage ?: "Data dosen gagal dimuat.",
            modifier = Modifier.padding(20.dp),
            color = MaterialTheme.colorScheme.error,
        )
        lecturer != null -> LecturerDashboardContent(lecturer)
    }
}

@Composable
private fun LecturerDashboardContent(lecturer: Lecturer) {
    val initials = lecturer.name
        .split(" ")
        .filter(String::isNotBlank)
        .take(2)
        .joinToString("") { it.first().toString() }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "Dashboard Dosen",
            style = MaterialTheme.typography.headlineSmall,
        )

        UniConnectCard {
            UniConnectAvatar(initials = initials)
            Text(lecturer.name, style = MaterialTheme.typography.titleLarge)
            Text("NIDN: ${lecturer.nidn}")
            Text(lecturer.department)
            UniConnectStatusChip(
                text = "Dosen Aktif",
                status = UniConnectStatus.SUCCESS,
            )
        }

        UniConnectCard {
            Text("Ringkasan Akademik", style = MaterialTheme.typography.titleMedium)
            Text("Kelola jadwal, presensi, nilai, dan aktivitas perkuliahan.")
        }
    }
}
