package com.fbi.uniconnect.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fbi.uniconnect.ui.screens.DashboardScreen
import com.fbi.uniconnect.ui.theme.UniConnectTheme

@Composable
fun UniConnectApp() {
    UniConnectTheme {
        Scaffold(
            topBar = { TopAppBar(title = { Text("UniConnect") }) }
        ) { padding ->
            Box(Modifier.padding(padding)) {
                DashboardScreen()
            }
        }
    }
}
