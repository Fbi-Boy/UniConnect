package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnnouncementsScreen() { Column(Modifier.fillMaxSize().padding(20.dp)) { Text("Pengumuman Kampus", style=MaterialTheme.typography.headlineSmall); Text("Pembayaran UKT dibuka minggu ini."); Text("Jadwal UTS telah diterbitkan.") } }
