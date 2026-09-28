package com.fbi.uniconnect.domain.usecase.auth

import com.fbi.uniconnect.domain.model.AuthUser
import com.fbi.uniconnect.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val repository: AuthRepository,
) {
    operator fun invoke(): AuthUser? = repository.getCurrentUser()
}
