package com.fbi.uniconnect.domain.model

data class Krs(val id:String,val courseName:String,val courseCode:String,val sks:Int,val lecturerName:String,val status:KrsStatus)
enum class KrsStatus(val label:String){ENROLLED("Diambil"),APPROVED("Disetujui"),DROPPED("Dibatalkan")}