package com.fbi.uniconnect.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fbi.uniconnect.domain.model.Attendance
import com.fbi.uniconnect.ui.components.UniConnectStatus
import com.fbi.uniconnect.ui.components.UniConnectStatusChip

@Composable
fun UniConnectAttendanceCard(
    attendance: Attendance,
    modifier: Modifier = Modifier,
) {
    UniConnectCard(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(attendance.courseName, style = MaterialTheme.typography.titleMedium)
                Text(attendance.date, style = MaterialTheme.typography.bodyMedium)
                attendance.note?.let {
                    Text(it, style = MaterialTheme.typography.bodySmall)
                }
            }
            UniConnectStatusChip(
                text = attendance.status.label,
                status = attendance.status.toUiStatus(),
            )
        }
    }
}

private fun com.fbi.uniconnect.domain.model.AttendanceStatus.toUiStatus(): UniConnectStatus =
    when (this) {
        com.fbi.uniconnect.domain.model.AttendanceStatus.PRESENT -> UniConnectStatus.SUCCESS
        com.fbi.uniconnect.domain.model.AttendanceStatus.LATE -> UniConnectStatus.WARNING
        com.fbi.uniconnect.domain.model.AttendanceStatus.ABSENT -> UniConnectStatus.ERROR
        com.fbi.uniconnect.domain.model.AttendanceStatus.EXCUSED -> UniConnectStatus.INFO
    }