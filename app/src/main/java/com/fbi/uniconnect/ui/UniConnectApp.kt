package com.fbi.uniconnect.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fbi.uniconnect.navigation.AppDestination
import com.fbi.uniconnect.navigation.UniConnectNavHost
import com.fbi.uniconnect.navigation.navigateToTopLevel
import com.fbi.uniconnect.ui.components.BottomNavigationBar
import com.fbi.uniconnect.ui.components.UniConnectTopBar
import com.fbi.uniconnect.ui.theme.UniConnectTheme

@Composable
fun UniConnectApp() {
    UniConnectTheme {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        val currentDestination = AppDestination.entries
            .firstOrNull { it.route == currentRoute }
        val showMainChrome = currentDestination?.showInBottomBar == true

        Scaffold(
            topBar = {
                if (showMainChrome) {
                    UniConnectTopBar(title = currentDestination.label)
                }
            },
            bottomBar = {
                if (showMainChrome) {
                    BottomNavigationBar(
                        currentRoute = currentRoute,
                        onDestinationSelected = navController::navigateToTopLevel,
                    )
                }
            },
        ) { padding ->
            Box(Modifier.padding(padding)) {
                UniConnectNavHost(navController)
            }
        }
    }
}
