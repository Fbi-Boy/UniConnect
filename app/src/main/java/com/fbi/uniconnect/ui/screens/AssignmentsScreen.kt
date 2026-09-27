package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AssignmentsScreen() { Column(Modifier.fillMaxSize().padding(20.dp)) { Text("Tugas", style=MaterialTheme.typography.headlineSmall); Text("Mobile App — Deadline Jumat"); Text("Database Design — Deadline Senin") } }
