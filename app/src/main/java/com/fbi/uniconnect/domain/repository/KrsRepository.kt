package com.fbi.uniconnect.domain.repository

import com.fbi.uniconnect.domain.model.Krs

interface KrsRepository {
    suspend fun getKrs(): List<Krs>
}
