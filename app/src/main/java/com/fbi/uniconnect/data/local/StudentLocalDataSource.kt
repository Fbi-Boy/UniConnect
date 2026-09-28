package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.core.database.StudentDao
import com.fbi.uniconnect.core.database.toDataModel
import com.fbi.uniconnect.core.database.toEntity
import com.fbi.uniconnect.data.model.Student
import javax.inject.Inject

class StudentLocalDataSource @Inject constructor(
    private val dao: StudentDao,
) {
    suspend fun getCurrentStudent(): Student {
        return dao.getCurrent()?.toDataModel() ?: Student(
            id = "student-001",
            name = "Mahasiswa UniConnect",
            nim = "00000000",
            studyProgram = "Teknologi Informasi",
            semester = 3,
            gpa = 3.72,
        ).also { dao.insert(it.toEntity()) }
    }
}
