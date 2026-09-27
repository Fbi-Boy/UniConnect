package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fbi.uniconnect.ui.components.SectionCard

@Composable
fun DashboardScreen() { Column(Modifier.fillMaxSize().padding(20.dp)) { Text("Halo, Mahasiswa!", style=MaterialTheme.typography.headlineSmall); Text("Ringkasan aktivitas akademikmu"); SectionCard("IPK Saat Ini") { Text("3.72") }; SectionCard("Jadwal Berikutnya") { Text("Pemrograman Mobile • 08:00") } } }
