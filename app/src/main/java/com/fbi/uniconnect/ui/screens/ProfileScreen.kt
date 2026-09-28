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
import com.fbi.uniconnect.ui.components.UniConnectAvatar
import com.fbi.uniconnect.ui.components.UniConnectCard
import com.fbi.uniconnect.ui.components.UniConnectLoading
import com.fbi.uniconnect.ui.components.UniConnectStatus
import com.fbi.uniconnect.ui.components.UniConnectStatusChip

@Composable
fun ProfileScreen(viewModel: StudentViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val student = state.student

    when {
        state.isLoading -> UniConnectLoading()
        state.errorMessage != null -> Text(
            text = state.errorMessage ?: "Data mahasiswa gagal dimuat.",
            modifier = Modifier.padding(20.dp),
            color = MaterialTheme.colorScheme.error,
        )
        student != null -> StudentProfileContent(student)
    }
}

@Composable
private fun StudentProfileContent(student: Student) {
    val initials = student.name
        .split(" ")
        .filter(String::isNotBlank)
        .take(2)
        .joinToString("") { it.first().toString() }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        UniConnectCard {
            UniConnectAvatar(initials = initials)
            Text(student.name, style = MaterialTheme.typography.titleLarge)
            Text(student.nim, style = MaterialTheme.typography.bodyMedium)
            Text(student.studyProgram, style = MaterialTheme.typography.bodyLarge)
            UniConnectStatusChip(
                text = "Mahasiswa Aktif",
                status = UniConnectStatus.SUCCESS,
            )
        }

        UniConnectCard {
            Text("Informasi Akademik", style = MaterialTheme.typography.titleMedium)
            Text("Program Studi: ${student.studyProgram}")
            Text("Semester: ${student.semester}")
            Text("IPK: %.2f".format(student.gpa))
        }
    }
}
