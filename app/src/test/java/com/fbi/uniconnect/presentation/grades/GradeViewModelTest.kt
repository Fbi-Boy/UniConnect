package com.fbi.uniconnect.presentation.grades

import com.fbi.uniconnect.MainDispatcherRule
import com.fbi.uniconnect.domain.model.*
import com.fbi.uniconnect.domain.repository.GradeRepository
import com.fbi.uniconnect.domain.usecase.grades.GetGradesUseCase
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
class GradeViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

 @Test fun loads_grades_into_ui_state() {
  val expected=listOf(Grade("1","Pemrograman Mobile",3,92.0,GradeLetter.A))
  val repository=object:GradeRepository{override suspend fun getGrades()=expected}
  val vm=GradeViewModel(GetGradesUseCase(repository))
  assertFalse(vm.uiState.value.isLoading)
  assertEquals(expected,vm.uiState.value.grades)
 }
}