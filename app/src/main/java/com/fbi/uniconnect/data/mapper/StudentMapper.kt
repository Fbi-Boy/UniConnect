package com.fbi.uniconnect.data.mapper

import com.fbi.uniconnect.data.model.Student as StudentData
import com.fbi.uniconnect.domain.model.Student as StudentDomain

fun StudentData.toDomain(): StudentDomain = StudentDomain(
    id = id,
    name = name,
    nim = nim,
    studyProgram = studyProgram,
    semester = semester,
    gpa = gpa,
)
