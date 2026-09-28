package com.fbi.uniconnect.ui.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fbi.uniconnect.presentation.krs.KrsViewModel
import com.fbi.uniconnect.ui.components.*
@Composable
fun KrsScreen(viewModel:KrsViewModel=hiltViewModel()){
val state by viewModel.uiState.collectAsStateWithLifecycle()
when{
state.isLoading->UniConnectLoading()
state.errorMessage!=null->Text(state.errorMessage!!,Modifier.padding(20.dp),color=MaterialTheme.colorScheme.error)
else->LazyColumn(Modifier.fillMaxSize().padding(horizontal=20.dp),verticalArrangement=Arrangement.spacedBy(12.dp),contentPadding=PaddingValues(vertical=20.dp)){
item{Column{Text("KRS",style=MaterialTheme.typography.headlineSmall);Text("Daftar mata kuliah semester berjalan",style=MaterialTheme.typography.bodyMedium)}}
items(state.courses,key={it.id}){UniConnectKrsCard(it)}}}}