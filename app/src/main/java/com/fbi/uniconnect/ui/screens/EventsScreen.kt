package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EventsScreen() { Column(Modifier.fillMaxSize().padding(20.dp)) { Text("Event Kampus", style=MaterialTheme.typography.headlineSmall); Text("Seminar Teknologi — 12 Oktober"); Text("Campus Expo — 20 Oktober") } }
