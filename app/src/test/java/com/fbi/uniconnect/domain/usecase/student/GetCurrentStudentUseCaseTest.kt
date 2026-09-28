package com.fbi.uniconnect.domain.usecase.student

import com.fbi.uniconnect.domain.model.Student
import com.fbi.uniconnect.domain.repository.StudentRepository
import org.junit.Assert.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetCurrentStudentUseCaseTest {

    @Test
    fun returns_student_from_repository() = runTest {
        val expected = Student(
            id = "student-001",
            name = "Fabi",
            nim = "12345",
            studyProgram = "Teknologi Informasi",
            semester = 3,
            gpa = 3.72,
        )
        val repository = object : StudentRepository {
            override suspend fun getCurrentStudent(): Student = expected
        }

        val result = GetCurrentStudentUseCase(repository)()

        assertEquals(expected, result)
    }
}
