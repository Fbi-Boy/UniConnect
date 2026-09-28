package com.fbi.uniconnect.domain.usecase.auth

import com.fbi.uniconnect.domain.model.AuthUser
import com.fbi.uniconnect.domain.repository.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository,
) {
    operator fun invoke(name: String, email: String, password: String): Result<AuthUser> =
        repository.register(name, email, password)
}
