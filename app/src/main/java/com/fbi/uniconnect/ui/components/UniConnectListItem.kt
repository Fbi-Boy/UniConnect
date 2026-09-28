package com.fbi.uniconnect.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fbi.uniconnect.ui.theme.UniConnectSpacing

@Composable
fun UniConnectListItem(
    title: String,
    subtitle: String? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    UniConnectCard(onClick = onClick) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(UniConnectSpacing.lg),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            leadingContent?.invoke()
            Column(
                modifier = Modifier.weight(1f).padding(horizontal = UniConnectSpacing.md),
            ) {
                Text(title, style = MaterialTheme.typography.titleMedium)
                subtitle?.let {
                    Text(it, style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            trailingContent?.invoke()
        }
    }
}
