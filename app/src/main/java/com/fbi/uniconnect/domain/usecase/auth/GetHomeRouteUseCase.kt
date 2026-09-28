package com.fbi.uniconnect.domain.usecase.auth

import com.fbi.uniconnect.domain.model.UserRole
import javax.inject.Inject

class GetHomeRouteUseCase @Inject constructor() {
    operator fun invoke(role: UserRole): String = when (role) {
        UserRole.STUDENT -> "dashboard"
        UserRole.LECTURER -> "lecturer-dashboard"
        UserRole.ADMIN -> "admin-dashboard"
    }
}
