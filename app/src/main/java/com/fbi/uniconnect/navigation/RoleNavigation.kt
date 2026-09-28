package com.fbi.uniconnect.navigation

import com.fbi.uniconnect.domain.model.UserRole

fun UserRole.homeRoute(): String = when (this) {
    UserRole.STUDENT -> AppDestination.Dashboard.route
    UserRole.LECTURER -> "lecturer-dashboard"
    UserRole.ADMIN -> "admin-dashboard"
}
