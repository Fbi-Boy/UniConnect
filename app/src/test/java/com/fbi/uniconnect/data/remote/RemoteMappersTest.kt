package com.fbi.uniconnect.data.remote

import com.fbi.uniconnect.domain.model.DayOfWeek
import com.fbi.uniconnect.domain.model.GradeLetter
import com.fbi.uniconnect.domain.model.KrsStatus
import org.junit.Assert.assertEquals
import org.junit.Test

class RemoteMappersTest {
    @Test
    fun scheduleDto_mapsToDataModel() {
        val model = ScheduleDto(
            "s1", "Pemrograman Mobile", "Budi", "MONDAY", "08:00", "09:40", "Lab RPL 1",
        ).toDataModel()

        assertEquals(DayOfWeek.MONDAY, model.day)
        assertEquals("Pemrograman Mobile", model.courseName)
        assertEquals("Lab RPL 1", model.room)
    }

    @Test
    fun gradeDto_mapsToDataModel() {
        val model = GradeDto("g1", "Basis Data", 3, 86.0, "AB").toDataModel()

        assertEquals(GradeLetter.AB, model.letter)
        assertEquals(86.0, model.score, 0.0)
    }

    @Test
    fun krsDto_mapsToDataModel() {
        val model = KrsDto("k1", "Basis Data", "BD01", 3, "Siti", "APPROVED").toDataModel()

        assertEquals(KrsStatus.APPROVED, model.status)
        assertEquals("BD01", model.courseCode)
    }

    @Test
    fun optionalFields_arePreserved() {
        val attendance = AttendanceDto("a1", "RPL", "2026-09-28", "EXCUSED", "Sakit").toDataModel()
        val assignment = AssignmentDto("a2", "Tugas", "RPL", "Deskripsi", "2026-10-01", "23:59", "PENDING").toDataModel()
        val announcement = AnnouncementDto("n1", "Info", "Isi", "Kampus", "2026-09-28", "ACADEMIC").toDataModel()

        assertEquals("Sakit", attendance.note)
        assertEquals("PENDING", assignment.status)
        assertEquals("ACADEMIC", announcement.category)
    }
}
