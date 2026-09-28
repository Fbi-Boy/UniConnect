package com.fbi.uniconnect.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fbi.uniconnect.ui.screens.DashboardScreen
import com.fbi.uniconnect.ui.screens.GradesScreen
import com.fbi.uniconnect.ui.screens.LecturerDashboardScreen
import com.fbi.uniconnect.ui.screens.LoginScreen
import com.fbi.uniconnect.ui.screens.OnboardingScreen
import com.fbi.uniconnect.ui.screens.ProfileScreen
import com.fbi.uniconnect.ui.screens.RegisterScreen
import com.fbi.uniconnect.ui.screens.ScheduleScreen
import com.fbi.uniconnect.ui.screens.SplashScreen

@Composable
fun UniConnectNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Splash.route,
    ) {
        composable(AppDestination.Splash.route) {
            SplashScreen(
                onContinue = {
                    navController.navigate(AppDestination.Onboarding.route) {
                        popUpTo(AppDestination.Splash.route) { inclusive = true }
                    }
                },
            )
        }
        composable(AppDestination.Onboarding.route) {
            OnboardingScreen(
                onContinue = {
                    navController.navigate(AppDestination.Login.route) {
                        popUpTo(AppDestination.Onboarding.route) { inclusive = true }
                    }
                },
            )
        }
        composable(AppDestination.Login.route) {
            LoginScreen(
                onLogin = {
                    navController.navigate(AppDestination.Dashboard.route) {
                        popUpTo(AppDestination.Login.route) { inclusive = true }
                    }
                },
                onRegister = { navController.navigate(AppDestination.Register.route) },
            )
        }
        composable(AppDestination.Register.route) {
            RegisterScreen(
                onRegister = {
                    navController.navigate(AppDestination.Dashboard.route) {
                        popUpTo(AppDestination.Login.route) { inclusive = true }
                    }
                },
                onBackToLogin = { navController.popBackStack() },
            )
        }
        composable(AppDestination.Dashboard.route) { DashboardScreen() }
        composable(AppDestination.Schedule.route) { ScheduleScreen() }
        composable(AppDestination.Grades.route) { GradesScreen() }
        composable(AppDestination.Profile.route) { ProfileScreen() }
        composable(AppDestination.LecturerDashboard.route) { LecturerDashboardScreen() }
    }
}
