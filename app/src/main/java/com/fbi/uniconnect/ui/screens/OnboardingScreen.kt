package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun OnboardingScreen(onContinue: () -> Unit) { Column(Modifier.fillMaxSize().padding(24.dp), Arrangement.Center, Alignment.CenterHorizontally) { Text("Selamat datang di UniConnect"); Spacer(Modifier.height(16.dp)); Text("Satu aplikasi untuk kebutuhan kampusmu."); Spacer(Modifier.height(24.dp)); Button(onClick = onContinue) { Text("Mulai") } } }
