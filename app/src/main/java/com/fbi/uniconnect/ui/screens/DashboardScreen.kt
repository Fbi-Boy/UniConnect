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
import com.fbi.uniconnect.domain.model.Student
import com.fbi.uniconnect.presentation.student.StudentViewModel
import com.fbi.uniconnect.ui.components.SectionCard
import com.fbi.uniconnect.ui.components.UniConnectLoading

@Composable
fun DashboardScreen(viewModel: StudentViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val student: Student? = state.student

    when {
        state.isLoading -> UniConnectLoading()
        state.errorMessage != null -> Text(
            text = state.errorMessage ?: "Data mahasiswa gagal dimuat.",
            modifier = Modifier.padding(20.dp),
            color = MaterialTheme.colorScheme.error,
        )
        student != null -> Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "Halo, ${student.name}!",
                style = MaterialTheme.typography.headlineSmall,
            )
            Text("Ringkasan aktivitas akademikmu")
            SectionCard("IPK Saat Ini") { Text("%.2f".format(student.gpa)) }
            SectionCard("Program Studi") { Text(student.studyProgram) }
            SectionCard("Semester") { Text(student.semester.toString()) }
        }
    }
}
