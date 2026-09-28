package com.fbi.uniconnect.ui.components
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fbi.uniconnect.domain.model.Grade
@Composable
fun UniConnectGradeCard(grade:Grade,modifier:Modifier=Modifier){
UniConnectCard(modifier=modifier){Row(Modifier.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceBetween){
Column(Modifier.weight(1f)){Text(grade.courseName,style=MaterialTheme.typography.titleMedium);Text("\${grade.sks} SKS • Nilai \${grade.score}",style=MaterialTheme.typography.bodyMedium)}
Text(grade.letter.label,style=MaterialTheme.typography.titleLarge)}}}