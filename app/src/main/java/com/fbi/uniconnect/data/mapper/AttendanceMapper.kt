package com.fbi.uniconnect.data.mapper

import com.fbi.uniconnect.data.model.Attendance as AttendanceData
import com.fbi.uniconnect.domain.model.Attendance as AttendanceDomain

fun AttendanceData.toDomain(): AttendanceDomain = AttendanceDomain(
    id = id,
    courseName = courseName,
    date = date,
    status = status,
    note = note,
)