package com.fbi.uniconnect.data.repository

import com.fbi.uniconnect.data.local.LecturerLocalDataSource
import com.fbi.uniconnect.data.mapper.toDomain
import com.fbi.uniconnect.domain.model.Lecturer
import com.fbi.uniconnect.domain.repository.LecturerRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LecturerRepositoryImpl @Inject constructor(
    private val localDataSource: LecturerLocalDataSource,
) : LecturerRepository {
    override suspend fun getCurrentLecturer(): Lecturer =
        localDataSource.getCurrentLecturer().toDomain()
}