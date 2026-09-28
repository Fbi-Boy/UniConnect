package com.fbi.uniconnect.presentation.announcements

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fbi.uniconnect.domain.model.Announcement
import com.fbi.uniconnect.domain.usecase.announcement.GetAnnouncementsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class AnnouncementUiState(
    val isLoading: Boolean = true,
    val announcements: List<Announcement> = emptyList(),
    val errorMessage: String? = null,
)

@HiltViewModel
class AnnouncementViewModel @Inject constructor(
    private val getAnnouncementsUseCase: GetAnnouncementsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AnnouncementUiState())
    val uiState: StateFlow<AnnouncementUiState> = _uiState.asStateFlow()

    init {
        loadAnnouncements()
    }

    private fun loadAnnouncements() {
        viewModelScope.launch {
            runCatching { getAnnouncementsUseCase() }
                .onSuccess { _uiState.value = AnnouncementUiState(false, it) }
                .onFailure { _uiState.value = AnnouncementUiState(false, emptyList(), it.message) }
        }
    }
}
