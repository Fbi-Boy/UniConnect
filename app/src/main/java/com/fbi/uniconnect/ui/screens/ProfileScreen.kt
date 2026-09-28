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
import com.fbi.uniconnect.ui.components.UniConnectStatusChip
import com.fbi.uniconnect.ui.theme.UniConnectStatus

@Composable
fun ProfileScreen(viewModel: StudentViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    when {
        state.isLoading -> UniConnectLoading()
        state.errorMessage != null -> Text(
            text = state.errorMessage,
            modifier = Modifier.padding(20.dp),
            color = MaterialTheme.colorScheme.error,
        )
        state.student != null -> StudentProfileContent(state.student!!)
    }
}

@Composable
private fun StudentProfileContent(student: Student) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        UniConnectCard {
            UniConnectAvatar(
                name = student.name,
                subtitle = student.nim,
                size = 64.dp,
            )
            Text(student.studyProgram, style = MaterialTheme.typography.bodyLarge)
            UniConnectStatusChip(
                label = "Mahasiswa Aktif",
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
