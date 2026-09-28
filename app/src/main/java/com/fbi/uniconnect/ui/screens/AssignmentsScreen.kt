package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.fbi.uniconnect.presentation.assignments.AssignmentViewModel
import com.fbi.uniconnect.ui.components.UniConnectAssignmentCard
import com.fbi.uniconnect.ui.components.UniConnectEmptyState
import com.fbi.uniconnect.ui.components.UniConnectLoading

@Composable
fun AssignmentsScreen(
    viewModel: AssignmentViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text("Tugas", style = MaterialTheme.typography.headlineSmall)
        when {
            state.isLoading -> UniConnectLoading()
            state.errorMessage != null -> Text(
                state.errorMessage ?: "Terjadi kesalahan.",
                color = MaterialTheme.colorScheme.error,
            )
            state.assignments.isEmpty() -> UniConnectEmptyState(message = "Belum ada tugas.")
            else -> LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(state.assignments, key = { it.id }) { assignment ->
                    UniConnectAssignmentCard(assignment)
                }
            }
        }
    }
}
