package com.fbi.uniconnect.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.weight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fbi.uniconnect.domain.model.Announcement
import com.fbi.uniconnect.domain.model.AnnouncementCategory

@Composable
fun UniConnectAnnouncementCard(
    announcement: Announcement,
    modifier: Modifier = Modifier,
) {
    UniConnectCard(modifier = modifier.fillMaxWidth()) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(announcement.title, style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(4.dp))
                    Text(announcement.publisher, style = MaterialTheme.typography.bodySmall)
                }
                UniConnectStatusChip(
                    text = announcement.category.label,
                    status = when (announcement.category) {
                        AnnouncementCategory.ACADEMIC -> UniConnectStatus.INFO
                        AnnouncementCategory.CAMPUS -> UniConnectStatus.SUCCESS
                        AnnouncementCategory.EVENT -> UniConnectStatus.WARNING
                        AnnouncementCategory.SYSTEM -> UniConnectStatus.ERROR
                    },
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(announcement.content, style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(12.dp))
            Text(
                text = announcement.publishedAt,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
