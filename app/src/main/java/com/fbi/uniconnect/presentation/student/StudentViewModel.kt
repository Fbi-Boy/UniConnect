package com.fbi.uniconnect.presentation.student

import androidx.lifecycle.ViewModel
import com.fbi.uniconnect.domain.model.Student
import com.fbi.uniconnect.domain.usecase.student.GetCurrentStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class StudentViewModel @Inject constructor(
    private val getCurrentStudent: GetCurrentStudentUseCase,
) : ViewModel() {

    private val _student = MutableStateFlow<Student?>(null)
    val student: StateFlow<Student?> = _student.asStateFlow()

    init {
        loadStudent()
    }

    private fun loadStudent() {
        _student.value = getCurrentStudent()
    }
}
