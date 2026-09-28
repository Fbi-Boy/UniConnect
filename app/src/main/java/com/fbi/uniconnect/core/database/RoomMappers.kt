package com.fbi.uniconnect.core.database

import com.fbi.uniconnect.data.model.Admin
import com.fbi.uniconnect.data.model.Announcement
import com.fbi.uniconnect.data.model.Assignment
import com.fbi.uniconnect.data.model.Attendance
import com.fbi.uniconnect.data.model.CourseSchedule
import com.fbi.uniconnect.data.model.Grade
import com.fbi.uniconnect.data.model.Krs
import com.fbi.uniconnect.data.model.Lecturer
import com.fbi.uniconnect.data.model.Student
import com.fbi.uniconnect.domain.model.AttendanceStatus
import com.fbi.uniconnect.domain.model.DayOfWeek
import com.fbi.uniconnect.domain.model.GradeLetter
import com.fbi.uniconnect.domain.model.KrsStatus

fun StudentEntity.toDataModel() = Student(id, name, nim, studyProgram, semester, gpa)
fun Student.toEntity() = StudentEntity(id, name, nim, studyProgram, semester, gpa)

fun LecturerEntity.toDataModel() = Lecturer(id, name, nidn, department, email)
fun Lecturer.toEntity() = LecturerEntity(id, name, nidn, department, email)

fun AdminEntity.toDataModel() = Admin(id, name, email)
fun Admin.toEntity() = AdminEntity(id, name, email)

fun CourseScheduleEntity.toDataModel() = CourseSchedule(
    id, courseName, lecturerName, DayOfWeek.valueOf(day), startTime, endTime, room
)
fun CourseSchedule.toEntity() = CourseScheduleEntity(
    id, courseName, lecturerName, day.name, startTime, endTime, room
)

fun AttendanceEntity.toDataModel() = Attendance(
    id, courseName, date, AttendanceStatus.valueOf(status), note
)
fun Attendance.toEntity() = AttendanceEntity(
    id, courseName, date, status.name, note
)

fun GradeEntity.toDataModel() = Grade(
    id, courseName, sks, score, GradeLetter.valueOf(letter)
)
fun Grade.toEntity() = GradeEntity(
    id, courseName, sks, score, letter.name
)

fun KrsEntity.toDataModel() = Krs(
    id, courseName, courseCode, sks, lecturerName, KrsStatus.valueOf(status)
)
fun Krs.toEntity() = KrsEntity(
    id, courseName, courseCode, sks, lecturerName, status.name
)

fun AssignmentEntity.toDataModel() = Assignment(
    id, title, courseName, description, dueDate, dueTime, status
)
fun Assignment.toEntity() = AssignmentEntity(
    id, title, courseName, description, dueDate, dueTime, status
)

fun AnnouncementEntity.toDataModel() = Announcement(
    id, title, content, publisher, publishedAt, category
)
fun Announcement.toEntity() = AnnouncementEntity(
    id, title, content, publisher, publishedAt, category
)
