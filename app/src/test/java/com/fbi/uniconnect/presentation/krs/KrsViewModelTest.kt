package com.fbi.uniconnect.presentation.krs
import com.fbi.uniconnect.domain.model.*
import com.fbi.uniconnect.domain.repository.KrsRepository
import com.fbi.uniconnect.domain.usecase.krs.GetKrsUseCase
import org.junit.Assert.*
import org.junit.Test
class KrsViewModelTest{
@Test fun loads_krs_into_ui_state(){
val expected=listOf(Krs("1","Pemrograman Mobile","TIF301",3,"Budi Santoso, M.Kom.",KrsStatus.APPROVED))
val repository=object:KrsRepository{override fun getKrs()=expected}
val vm=KrsViewModel(GetKrsUseCase(repository))
assertFalse(vm.uiState.value.isLoading);assertEquals(expected,vm.uiState.value.courses)}}