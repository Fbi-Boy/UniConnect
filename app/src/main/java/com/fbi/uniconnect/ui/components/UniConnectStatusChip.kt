package com.fbi.uniconnect.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class UniConnectStatus {
    SUCCESS, WARNING, ERROR, INFO
}

@Composable
fun UniConnectStatusChip(
    text: String,
    status: UniConnectStatus = UniConnectStatus.INFO,
) {
    val (container, content) = when (status) {
        UniConnectStatus.SUCCESS -> MaterialTheme.colorScheme.tertiaryContainer to MaterialTheme.colorScheme.onTertiaryContainer
        UniConnectStatus.WARNING -> MaterialTheme.colorScheme.secondaryContainer to MaterialTheme.colorScheme.onSecondaryContainer
        UniConnectStatus.ERROR -> MaterialTheme.colorScheme.errorContainer to MaterialTheme.colorScheme.onErrorContainer
        UniConnectStatus.INFO -> MaterialTheme.colorScheme.primaryContainer to MaterialTheme.colorScheme.onPrimaryContainer
    }

    Text(
        text = text,
        color = content,
        style = MaterialTheme.typography.labelMedium,
        modifier = Modifier
            .background(container, RoundedCornerShape(50))
            .padding(horizontal = 10.dp, vertical = 6.dp),
    )
}
