package com.fbi.uniconnect.domain.model

data class CourseSchedule(val id:String,val courseName:String,val lecturerName:String,val day:DayOfWeek,val startTime:String,val endTime:String,val room:String)
enum class DayOfWeek(val label:String){ MONDAY("Senin"), TUESDAY("Selasa"), WEDNESDAY("Rabu"), THURSDAY("Kamis"), FRIDAY("Jumat") }