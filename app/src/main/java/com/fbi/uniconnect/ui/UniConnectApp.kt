package com.fbi.uniconnect.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fbi.uniconnect.navigation.AppDestination
import com.fbi.uniconnect.navigation.UniConnectNavHost
import com.fbi.uniconnect.ui.components.BottomNavigationBar
import com.fbi.uniconnect.ui.theme.UniConnectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UniConnectApp() {
    UniConnectTheme {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            AppDestination.entries
                                .firstOrNull { it.route == currentRoute }
                                ?.label
                                ?: "UniConnect",
                        )
                    },
                )
            },
            bottomBar = {
                BottomNavigationBar(
                    currentRoute = currentRoute,
                    onDestinationSelected = { destination ->
                        navController.navigate(destination.route) {
                            popUpTo(AppDestination.Dashboard.route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                )
            },
        ) { padding ->
            androidx.compose.foundation.layout.Box(Modifier.padding(padding)) {
                UniConnectNavHost(navController)
            }
        }
    }
}
