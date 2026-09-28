package com.fbi.uniconnect.data.mapper

import com.fbi.uniconnect.data.model.Admin as AdminData
import com.fbi.uniconnect.domain.model.Admin as AdminDomain

fun AdminData.toDomain(): AdminDomain = AdminDomain(
    id = id,
    name = name,
    email = email,
)
