package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() { Column(Modifier.fillMaxSize().padding(20.dp)) { Text("Profil Mahasiswa", style=MaterialTheme.typography.headlineSmall); Spacer(Modifier.height(16.dp)); Text("Nama: Mahasiswa UniConnect"); Text("NIM: 00000000"); Text("Program Studi: Teknologi Informasi") } }
