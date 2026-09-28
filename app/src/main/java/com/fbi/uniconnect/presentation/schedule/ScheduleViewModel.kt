package com.fbi.uniconnect.presentation.schedule
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fbi.uniconnect.domain.model.CourseSchedule
import com.fbi.uniconnect.domain.usecase.schedule.GetSchedulesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
data class ScheduleUiState(val isLoading:Boolean=true,val schedules:List<CourseSchedule> = emptyList(),val errorMessage:String?=null)
@HiltViewModel class ScheduleViewModel @Inject constructor(private val getSchedules:GetSchedulesUseCase):ViewModel(){
private val _uiState=MutableStateFlow(ScheduleUiState()); val uiState:StateFlow<ScheduleUiState> = _uiState.asStateFlow()
init{loadSchedules()}
fun loadSchedules(){viewModelScope.launch{_uiState.value=ScheduleUiState();runCatching{getSchedules()}.onSuccess{_uiState.value=ScheduleUiState(false,it)}.onFailure{_uiState.value=ScheduleUiState(false,errorMessage=it.message?:"Jadwal gagal dimuat.")}}}}