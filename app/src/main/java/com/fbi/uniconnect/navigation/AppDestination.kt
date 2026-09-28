package com.fbi.uniconnect.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.AppRegistration
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppDestination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val showInBottomBar: Boolean = false,
) {
    Splash("splash", "Splash", Icons.Default.Home),
    Onboarding("onboarding", "Onboarding", Icons.Default.Home),
    Login("login", "Login", Icons.Default.Login),
    Register("register", "Register", Icons.Default.AppRegistration),
    Dashboard("dashboard", "Dashboard", Icons.Default.Home, true),
    Schedule("schedule", "Jadwal", Icons.Default.CalendarMonth, true),
    Grades("grades", "Nilai", Icons.Default.School, true),
    Profile("profile", "Profil", Icons.Default.Person, true),
    LecturerDashboard("lecturer-dashboard", "Dashboard Dosen", Icons.Default.School),
    AdminDashboard("admin-dashboard", "Dashboard Admin", Icons.Default.Person),
}
