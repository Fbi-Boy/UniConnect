package com.fbi.uniconnect.data.model
import com.fbi.uniconnect.domain.model.DayOfWeek
data class CourseSchedule(val id:String,val courseName:String,val lecturerName:String,val day:DayOfWeek,val startTime:String,val endTime:String,val room:String)