package com.fbi.uniconnect.data.mapper
import com.fbi.uniconnect.data.model.Grade as GradeData
import com.fbi.uniconnect.domain.model.Grade as GradeDomain
fun GradeData.toDomain():GradeDomain=GradeDomain(id,courseName,sks,score,letter)