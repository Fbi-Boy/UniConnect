package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.data.model.Student
import javax.inject.Inject

class StudentLocalDataSource @Inject constructor() {
    fun getCurrentStudent(): Student = Student(
        id = "student-001",
        name = "Mahasiswa UniConnect",
        nim = "00000000",
        studyProgram = "Teknologi Informasi",
        semester = 3,
        gpa = 3.72,
    )
}
