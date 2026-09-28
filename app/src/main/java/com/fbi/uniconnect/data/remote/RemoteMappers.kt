package com.fbi.uniconnect.data.remote

import com.fbi.uniconnect.data.model.CourseSchedule
import com.fbi.uniconnect.data.model.Attendance
import com.fbi.uniconnect.data.model.Grade
import com.fbi.uniconnect.data.model.Krs
import com.fbi.uniconnect.data.model.Assignment
import com.fbi.uniconnect.data.model.Announcement
import com.fbi.uniconnect.domain.model.AttendanceStatus
import com.fbi.uniconnect.domain.model.DayOfWeek
import com.fbi.uniconnect.domain.model.GradeLetter
import com.fbi.uniconnect.domain.model.KrsStatus

fun ScheduleDto.toDataModel(): CourseSchedule = CourseSchedule(
    id = id,
    courseName = courseName,
    lecturerName = lecturerName,
    day = DayOfWeek.valueOf(day.uppercase()),
    startTime = startTime,
    endTime = endTime,
    room = room,
)

fun AttendanceDto.toDataModel(): Attendance = Attendance(
    id = id,
    courseName = courseName,
    date = date,
    status = AttendanceStatus.valueOf(status.uppercase()),
    note = note,
)

fun GradeDto.toDataModel(): Grade = Grade(
    id = id,
    courseName = courseName,
    sks = sks,
    score = score,
    letter = GradeLetter.valueOf(letter.uppercase()),
)

fun KrsDto.toDataModel(): Krs = Krs(
    id = id,
    courseName = courseName,
    courseCode = courseCode,
    sks = sks,
    lecturerName = lecturerName,
    status = KrsStatus.valueOf(status.uppercase()),
)

fun AssignmentDto.toDataModel(): Assignment = Assignment(
    id = id,
    title = title,
    courseName = courseName,
    description = description,
    dueDate = dueDate,
    dueTime = dueTime,
    status = status,
)

fun AnnouncementDto.toDataModel(): Announcement = Announcement(
    id = id,
    title = title,
    content = content,
    publisher = publisher,
    publishedAt = publishedAt,
    category = category,
)
