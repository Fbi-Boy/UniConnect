package com.fbi.uniconnect.data.mapper

import com.fbi.uniconnect.data.model.Assignment as AssignmentData
import com.fbi.uniconnect.domain.model.Assignment as AssignmentDomain
import com.fbi.uniconnect.domain.model.AssignmentStatus

fun AssignmentData.toDomain(): AssignmentDomain = AssignmentDomain(
    id = id,
    title = title,
    courseName = courseName,
    description = description,
    dueDate = dueDate,
    dueTime = dueTime,
    status = AssignmentStatus.valueOf(status),
)
