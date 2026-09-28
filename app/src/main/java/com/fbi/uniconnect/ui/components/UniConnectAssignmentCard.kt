package com.fbi.uniconnect.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fbi.uniconnect.domain.model.Assignment
import com.fbi.uniconnect.domain.model.AssignmentStatus

@Composable
fun UniConnectAssignmentCard(
    assignment: Assignment,
    modifier: Modifier = Modifier,
) {
    UniConnectCard(modifier = modifier.fillMaxWidth()) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(assignment.title, style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(4.dp))
                    Text(assignment.courseName, style = MaterialTheme.typography.bodyMedium)
                }
                UniConnectStatusChip(
                    text = assignment.status.label,
                    status = when (assignment.status) {
                        AssignmentStatus.PENDING -> UniConnectStatus.WARNING
                        AssignmentStatus.SUBMITTED -> UniConnectStatus.SUCCESS
                        AssignmentStatus.OVERDUE -> UniConnectStatus.ERROR
                    },
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(assignment.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(12.dp))
            Text(
                text = "Deadline: " + assignment.dueDate + " • " + assignment.dueTime,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
