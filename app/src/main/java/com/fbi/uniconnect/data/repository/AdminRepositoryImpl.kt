package com.fbi.uniconnect.data.repository

import com.fbi.uniconnect.data.local.AdminLocalDataSource
import com.fbi.uniconnect.data.mapper.toDomain
import com.fbi.uniconnect.domain.model.Admin
import com.fbi.uniconnect.domain.repository.AdminRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdminRepositoryImpl @Inject constructor(
    private val localDataSource: AdminLocalDataSource,
) : AdminRepository {
    override fun getCurrentAdmin(): Admin =
        localDataSource.getCurrentAdmin().toDomain()
}
