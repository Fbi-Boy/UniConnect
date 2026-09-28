package com.fbi.uniconnect.data.mapper
import com.fbi.uniconnect.data.model.CourseSchedule as DataSchedule
import com.fbi.uniconnect.domain.model.CourseSchedule as DomainSchedule
fun DataSchedule.toDomain()=DomainSchedule(id,courseName,lecturerName,day,startTime,endTime,room)