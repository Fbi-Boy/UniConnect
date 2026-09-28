package com.fbi.uniconnect.ui.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fbi.uniconnect.domain.model.Krs
import com.fbi.uniconnect.domain.model.KrsStatus
@Composable
fun UniConnectKrsCard(krs:Krs,modifier:Modifier=Modifier){
UniConnectCard(modifier=modifier){Row(Modifier.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceBetween){
Column(Modifier.weight(1f)){Text(krs.courseName,style=MaterialTheme.typography.titleMedium);Text(krs.courseCode+" • "+krs.sks+" SKS",style=MaterialTheme.typography.bodyMedium);Text(krs.lecturerName,style=MaterialTheme.typography.bodySmall)}
UniConnectStatusChip(text=krs.status.label,status=when(krs.status){KrsStatus.APPROVED->UniConnectStatus.SUCCESS;KrsStatus.ENROLLED->UniConnectStatus.INFO;KrsStatus.DROPPED->UniConnectStatus.ERROR})}}}