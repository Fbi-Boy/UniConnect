package com.fbi.uniconnect.data.model
import com.fbi.uniconnect.domain.model.GradeLetter
data class Grade(val id:String,val courseName:String,val sks:Int,val score:Double,val letter:GradeLetter)