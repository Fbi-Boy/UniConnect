package com.fbi.uniconnect.data.model

data class Student(
    val id: String,
    val name: String,
    val nim: String,
    val studyProgram: String,
    val semester: Int,
    val gpa: Double
)
