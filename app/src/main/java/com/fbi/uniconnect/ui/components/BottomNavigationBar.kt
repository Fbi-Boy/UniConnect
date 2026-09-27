package com.fbi.uniconnect.ui.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.fbi.uniconnect.navigation.AppDestination

@Composable
fun BottomNavigationBar(currentRoute: String, onDestinationSelected: (String) -> Unit) {
    NavigationBar {
        AppDestination.entries.forEach { destination ->
            NavigationBarItem(
                selected = currentRoute == destination.route,
                onClick = { onDestinationSelected(destination.route) },
                icon = { Text(destination.label.take(1)) },
                label = { Text(destination.label) }
            )
        }
    }
}
