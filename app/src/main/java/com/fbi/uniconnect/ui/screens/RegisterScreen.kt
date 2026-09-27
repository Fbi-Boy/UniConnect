package com.fbi.uniconnect.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RegisterScreen(onRegister: () -> Unit) { var name by remember { mutableStateOf("") }; Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) { Text("Buat akun mahasiswa"); Spacer(Modifier.height(16.dp)); OutlinedTextField(name,{name=it},Modifier.fillMaxWidth(),label={Text("Nama lengkap")}); Spacer(Modifier.height(16.dp)); Button(onClick=onRegister,Modifier.fillMaxWidth()){Text("Daftar")}}}
