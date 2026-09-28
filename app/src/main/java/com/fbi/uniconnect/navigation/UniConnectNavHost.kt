package com.fbi.uniconnect.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fbi.uniconnect.ui.screens.DashboardScreen
import com.fbi.uniconnect.ui.screens.GradesScreen
import com.fbi.uniconnect.ui.screens.ProfileScreen
import com.fbi.uniconnect.ui.screens.ScheduleScreen

@Composable
fun UniConnectNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Dashboard.route,
    ) {
        composable(AppDestination.Dashboard.route) { DashboardScreen() }
        composable(AppDestination.Schedule.route) { ScheduleScreen() }
        composable(AppDestination.Grades.route) { GradesScreen() }
        composable(AppDestination.Profile.route) { ProfileScreen() }
    }
}
