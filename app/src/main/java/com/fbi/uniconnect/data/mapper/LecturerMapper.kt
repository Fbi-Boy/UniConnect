package com.fbi.uniconnect.data.mapper

import com.fbi.uniconnect.data.model.Lecturer as LecturerData
import com.fbi.uniconnect.domain.model.Lecturer as LecturerDomain

fun LecturerData.toDomain(): LecturerDomain = LecturerDomain(
    id = id,
    name = name,
    nidn = nidn,
    department = department,
    email = email,
)
