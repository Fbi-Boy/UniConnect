package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GradesScreen() { Column(Modifier.fillMaxSize().padding(20.dp)) { Text("Nilai Akademik", style=MaterialTheme.typography.headlineSmall); Text("Pemrograman Mobile — A"); Text("Basis Data — A-"); Text("Statistika — B+") } }
