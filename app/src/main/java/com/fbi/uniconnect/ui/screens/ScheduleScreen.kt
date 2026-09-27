package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScheduleScreen() { Column(Modifier.fillMaxSize().padding(20.dp)) { Text("Jadwal Kuliah", style=MaterialTheme.typography.headlineSmall); listOf("Pemrograman Mobile • Senin 08:00", "Basis Data • Selasa 10:00", "Statistika • Rabu 13:00").forEach { Text(it, Modifier.padding(vertical=12.dp)) } } }
