package com.fbi.uniconnect.navigation

import androidx.navigation.NavHostController

fun NavHostController.navigateToTopLevel(destination: AppDestination) {
    navigate(destination.route) {
        popUpTo(AppDestination.Dashboard.route) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
