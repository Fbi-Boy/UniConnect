package com.fbi.uniconnect.core.database

import com.fbi.uniconnect.domain.model.AttendanceStatus
import com.fbi.uniconnect.domain.model.DayOfWeek
import com.fbi.uniconnect.domain.model.GradeLetter
import com.fbi.uniconnect.domain.model.KrsStatus
import org.junit.Assert.assertEquals
import org.junit.Test

class RoomMappersTest {
    @Test
    fun studentEntity_roundTripsThroughRoomMapper() {
        val student = com.fbi.uniconnect.data.model.Student(
            "student-1", "Fabi", "123", "Teknologi Informasi", 3, 3.72
        )
        assertEquals(student, student.toEntity().toDataModel())
    }

    @Test
    fun enumBackedAcademicEntities_preserveEnumNames() {
        val schedule = com.fbi.uniconnect.data.model.CourseSchedule(
            "schedule-1", "Basis Data", "Dosen", DayOfWeek.TUESDAY, "10:00", "11:40", "204"
        )
        val attendance = com.fbi.uniconnect.data.model.Attendance(
            "attendance-1", "Basis Data", "23 September 2026", AttendanceStatus.LATE
        )
        val grade = com.fbi.uniconnect.data.model.Grade(
            "grade-1", "Basis Data", 3, 86.0, GradeLetter.AB
        )
        val krs = com.fbi.uniconnect.data.model.Krs(
            "krs-1", "Basis Data", "TIF302", 3, "Dosen", KrsStatus.APPROVED
        )

        assertEquals(schedule, schedule.toEntity().toDataModel())
        assertEquals(attendance, attendance.toEntity().toDataModel())
        assertEquals(grade, grade.toEntity().toDataModel())
        assertEquals(krs, krs.toEntity().toDataModel())
    }
}
