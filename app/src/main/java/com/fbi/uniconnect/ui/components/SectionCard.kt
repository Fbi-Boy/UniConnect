package com.fbi.uniconnect.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fbi.uniconnect.ui.theme.UniConnectSpacing

@Composable
fun SectionCard(
    title: String,
    content: @Composable () -> Unit,
) {
    UniConnectCard(
        modifier = Modifier.padding(vertical = UniConnectSpacing.sm),
    ) {
        Column(modifier = Modifier.padding(UniConnectSpacing.lg)) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            content()
        }
    }
}
