package com.fbi.uniconnect.data.mapper
import com.fbi.uniconnect.data.model.Krs as KrsData
import com.fbi.uniconnect.domain.model.Krs as KrsDomain
fun KrsData.toDomain():KrsDomain=KrsDomain(id,courseName,courseCode,sks,lecturerName,status)