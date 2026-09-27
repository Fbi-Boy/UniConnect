package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onLogin: () -> Unit) { var email by remember { mutableStateOf("") }; var password by remember { mutableStateOf("") }; Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) { Text("Masuk ke UniConnect"); Spacer(Modifier.height(16.dp)); OutlinedTextField(email, { email = it }, Modifier.fillMaxWidth(), label={Text("Email")}); Spacer(Modifier.height(8.dp)); OutlinedTextField(password, { password = it }, Modifier.fillMaxWidth(), label={Text("Password")}); Spacer(Modifier.height(16.dp)); Button(onClick=onLogin, Modifier.fillMaxWidth()) { Text("Login") } } }
