package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.Lecturer

interface LecturerRepository {
    suspend fun getCurrentLecturer(): Lecturer
}
