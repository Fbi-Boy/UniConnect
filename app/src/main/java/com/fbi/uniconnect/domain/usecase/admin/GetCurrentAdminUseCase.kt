package com.fbi.uniconnect.domain.usecase.admin

import com.fbi.uniconnect.domain.model.Admin
import com.fbi.uniconnect.domain.repository.AdminRepository
import javax.inject.Inject

class GetCurrentAdminUseCase @Inject constructor(
    private val repository: AdminRepository,
) {
    suspend operator fun invoke(): Admin = repository.getCurrentAdmin()
}