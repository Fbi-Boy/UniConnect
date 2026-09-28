package com.fbi.uniconnect.domain.usecase.krs

import com.fbi.uniconnect.domain.model.Krs
import com.fbi.uniconnect.domain.repository.KrsRepository
import javax.inject.Inject

class GetKrsUseCase @Inject constructor(
    private val repository: KrsRepository,
) {
    operator fun invoke(): List<Krs> = repository.getKrs()
}