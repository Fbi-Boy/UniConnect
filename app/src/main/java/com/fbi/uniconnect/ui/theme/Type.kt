package com.fbi.uniconnect.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontWeight

val UniConnectTypography = Typography().run {
    copy(
        displayLarge = displayLarge.copy(fontWeight = FontWeight.Bold),
        headlineLarge = headlineLarge.copy(fontWeight = FontWeight.Bold),
        headlineMedium = headlineMedium.copy(fontWeight = FontWeight.SemiBold),
        headlineSmall = headlineSmall.copy(fontWeight = FontWeight.SemiBold),
        titleLarge = titleLarge.copy(fontWeight = FontWeight.SemiBold),
        titleMedium = titleMedium.copy(fontWeight = FontWeight.SemiBold),
        bodyLarge = bodyLarge.copy(fontWeight = FontWeight.Normal),
        bodyMedium = bodyMedium.copy(fontWeight = FontWeight.Normal),
        labelLarge = labelLarge.copy(fontWeight = FontWeight.SemiBold),
    )
}
