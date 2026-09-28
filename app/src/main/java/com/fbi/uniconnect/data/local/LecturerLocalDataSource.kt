package com.fbi.uniconnect.data.local

import com.fbi.uniconnect.data.model.Lecturer
import javax.inject.Inject

class LecturerLocalDataSource @Inject constructor() {
    fun getCurrentLecturer(): Lecturer = Lecturer(
        id = "lecturer-001",
        name = "Dosen UniConnect",
        nidn = "0000000000",
        department = "Teknologi Informasi",
        email = "lecturer@uniconnect.app",
    )
}
