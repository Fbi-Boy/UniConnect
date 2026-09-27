package com.fbi.uniconnect.data.repository

import com.fbi.uniconnect.data.model.Student

class StudentRepository {
    fun getCurrentStudent(): Student = Student(
        id = "student-001",
        name = "Mahasiswa UniConnect",
        nim = "00000000",
        studyProgram = "Teknologi Informasi",
        semester = 3,
        gpa = 3.72
    )
}
