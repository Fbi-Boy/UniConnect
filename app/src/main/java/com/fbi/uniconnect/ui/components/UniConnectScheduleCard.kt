package com.fbi.uniconnect.ui.components
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fbi.uniconnect.domain.model.CourseSchedule
@Composable fun UniConnectScheduleCard(schedule:CourseSchedule,modifier:Modifier=Modifier){
UniConnectCard(modifier=modifier){Row(Modifier.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceBetween){
Column(Modifier.weight(1f)){Text(schedule.courseName,style=MaterialTheme.typography.titleMedium);Text(schedule.lecturerName,style=MaterialTheme.typography.bodyMedium);Text("${schedule.day.label} • ${schedule.room}",style=MaterialTheme.typography.bodySmall)}
Text("${schedule.startTime}–${schedule.endTime}",style=MaterialTheme.typography.labelLarge)}}}