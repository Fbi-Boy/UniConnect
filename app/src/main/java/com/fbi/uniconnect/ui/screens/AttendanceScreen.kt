package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fbi.uniconnect.presentation.attendance.AttendanceViewModel
import com.fbi.uniconnect.ui.components.UniConnectAttendanceCard
import com.fbi.uniconnect.ui.components.UniConnectLoading

@Composable
fun AttendanceScreen(
    viewModel: AttendanceViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    when {
        state.isLoading -> UniConnectLoading()
        state.errorMessage != null -> Text(
            text = state.errorMessage ?: "Data kehadiran gagal dimuat.",
            modifier = Modifier.padding(20.dp),
            color = MaterialTheme.colorScheme.error,
        )
        else -> LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 20.dp),
        ) {
            item {
                Column {
                    Text("Kehadiran", style = MaterialTheme.typography.headlineSmall)
                    Text(
                        "Riwayat kehadiran perkuliahan",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
            items(state.attendances, key = { it.id }) { attendance ->
                UniConnectAttendanceCard(attendance)
            }
        }
    }
}