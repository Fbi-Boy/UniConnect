package com.fbi.uniconnect.presentation.announcements

import com.fbi.uniconnect.domain.model.Announcement
import com.fbi.uniconnect.domain.model.AnnouncementCategory
import com.fbi.uniconnect.domain.repository.AnnouncementRepository
import com.fbi.uniconnect.domain.usecase.announcement.GetAnnouncementsUseCase
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AnnouncementViewModelTest {
    @Test
    fun loadsAnnouncementsIntoUiState() = runTest(StandardTestDispatcher()) {
        val repository = object : AnnouncementRepository {
            override fun getAnnouncements(): List<Announcement> = listOf(
                Announcement(
                    "1", "Pengumuman", "Isi", "Akademik",
                    "28 September 2026", AnnouncementCategory.ACADEMIC,
                ),
            )
        }
        val viewModel = AnnouncementViewModel(GetAnnouncementsUseCase(repository))
        assertEquals(1, viewModel.uiState.value.announcements.size)
    }
}
