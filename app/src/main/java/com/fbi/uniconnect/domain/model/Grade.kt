package com.fbi.uniconnect.domain.model
data class Grade(val id:String,val courseName:String,val sks:Int,val score:Double,val letter:GradeLetter)
enum class GradeLetter(val label:String){A("A"),AB("AB"),B("B"),BC("BC"),C("C"),D("D"),E("E")}