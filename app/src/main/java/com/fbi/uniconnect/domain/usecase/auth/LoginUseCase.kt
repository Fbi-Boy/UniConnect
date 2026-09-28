package com.fbi.uniconnect.domain.usecase.auth

import com.fbi.uniconnect.domain.model.AuthUser
import com.fbi.uniconnect.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository,
) {
    operator fun invoke(email: String, password: String): Result<AuthUser> =
        repository.login(email, password)
}
