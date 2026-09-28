package com.fbi.uniconnect.data.remote

import com.fbi.uniconnect.core.network.NetworkResult
import java.io.IOException
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AcademicRemoteDataSourceTest {
    @Test
    fun getSchedules_returnsMappedRemoteData() = runTest {
        val api = FakeApi(
            schedules = listOf(
                ScheduleDto("s1", "Basis Data", "Siti", "TUESDAY", "10:00", "11:40", "204"),
            ),
        )
        val result = AcademicRemoteDataSource(api).getSchedules()

        assertTrue(result is NetworkResult.Success)
        assertEquals("Basis Data", (result as NetworkResult.Success).data.single().courseName)
    }

    @Test
    fun getSchedules_convertsNetworkFailureToNetworkResult() = runTest {
        val result = AcademicRemoteDataSource(FakeApi(failure = IOException("offline"))).getSchedules()

        assertTrue(result is NetworkResult.NetworkError)
    }

    private class FakeApi(
        private val schedules: List<ScheduleDto> = emptyList(),
        private val failure: IOException? = null,
    ) : UniConnectApi {
        override suspend fun health() = HealthResponse("ok")

        override suspend fun getSchedules(): List<ScheduleDto> {
            failure?.let { throw it }
            return schedules
        }

        override suspend fun getAttendance() = emptyList<AttendanceDto>()
        override suspend fun getGrades() = emptyList<GradeDto>()
        override suspend fun getKrs() = emptyList<KrsDto>()
        override suspend fun getAssignments() = emptyList<AssignmentDto>()
        override suspend fun getAnnouncements() = emptyList<AnnouncementDto>()
    }
}
