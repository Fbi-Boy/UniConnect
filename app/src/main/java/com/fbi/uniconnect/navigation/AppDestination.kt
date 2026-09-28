package com.fbi.uniconnect.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppDestination(
    val route: String,
    val label: String,
    val icon: ImageVector,
) {
    Dashboard("dashboard", "Dashboard", Icons.Default.Home),
    Schedule("schedule", "Jadwal", Icons.Default.CalendarMonth),
    Grades("grades", "Nilai", Icons.Default.School),
    Profile("profile", "Profil", Icons.Default.Person),
}
