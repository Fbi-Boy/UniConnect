package com.fbi.uniconnect.data.local
import com.fbi.uniconnect.data.model.CourseSchedule
import com.fbi.uniconnect.domain.model.DayOfWeek
import javax.inject.Inject
class ScheduleLocalDataSource @Inject constructor(){ fun getSchedules()=listOf(
CourseSchedule("schedule-001","Pemrograman Mobile","Budi Santoso, M.Kom.",DayOfWeek.MONDAY,"08:00","09:40","Lab RPL 1"),
CourseSchedule("schedule-002","Basis Data","Siti Aminah, M.Kom.",DayOfWeek.TUESDAY,"10:00","11:40","Ruang 204"),
CourseSchedule("schedule-003","Statistika","Andi Pratama, M.Si.",DayOfWeek.WEDNESDAY,"13:00","14:40","Ruang 301"),
CourseSchedule("schedule-004","Rekayasa Perangkat Lunak","Dewi Lestari, M.Kom.",DayOfWeek.THURSDAY,"08:00","09:40","Ruang 105"),
CourseSchedule("schedule-005","Kewirausahaan","Rina Wijaya, M.M.",DayOfWeek.FRIDAY,"09:00","10:40","Ruang 202")) }