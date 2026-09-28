package com.fbi.uniconnect.presentation.schedule
import com.fbi.uniconnect.domain.model.*
import com.fbi.uniconnect.domain.repository.ScheduleRepository
import com.fbi.uniconnect.domain.usecase.schedule.GetSchedulesUseCase
import org.junit.Assert.*
import org.junit.Test
class ScheduleViewModelTest{@Test fun loads_schedules_into_ui_state(){
val expected=listOf(CourseSchedule("1","Pemrograman Mobile","Dosen",DayOfWeek.MONDAY,"08:00","09:40","Lab"))
val repository=object:ScheduleRepository{override suspend fun getSchedules()=expected}
val viewModel=ScheduleViewModel(GetSchedulesUseCase(repository))
assertFalse(viewModel.uiState.value.isLoading);assertEquals(expected,viewModel.uiState.value.schedules)}}