package com.fbi.uniconnect.data.model
import com.fbi.uniconnect.domain.model.KrsStatus
data class Krs(val id:String,val courseName:String,val courseCode:String,val sks:Int,val lecturerName:String,val status:KrsStatus)