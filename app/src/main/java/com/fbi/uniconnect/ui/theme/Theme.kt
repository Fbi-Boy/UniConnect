package com.fbi.uniconnect.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = UniConnectBlue,
    onPrimary = UniConnectOnBlue,
    primaryContainer = UniConnectBlueContainer,
    onPrimaryContainer = UniConnectOnBlueContainer,
    secondary = UniConnectInfo,
    onSecondary = Color.White,
    secondaryContainer = UniConnectInfoContainer,
    onSecondaryContainer = UniConnectDarkText,
    tertiary = UniConnectSuccess,
    onTertiary = Color.White,
    tertiaryContainer = UniConnectSuccessContainer,
    onTertiaryContainer = UniConnectDarkText,
    background = UniConnectLightBackground,
    onBackground = UniConnectLightText,
    surface = UniConnectLightSurface,
    onSurface = UniConnectLightText,
    surfaceVariant = UniConnectLightSurfaceVariant,
    onSurfaceVariant = UniConnectLightTextSecondary,
    outline = UniConnectLightOutline,
    error = UniConnectError,
    onError = Color.White,
    errorContainer = UniConnectErrorContainer,
    onErrorContainer = UniConnectDarkText,
)

private val DarkColors = darkColorScheme(
    primary = UniConnectBlueDark,
    onPrimary = UniConnectOnBlueDark,
    primaryContainer = UniConnectBlueDarkContainer,
    onPrimaryContainer = UniConnectOnBlueDarkContainer,
    secondary = UniConnectInfo,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF164E63),
    onSecondaryContainer = Color(0xFFCFFAFE),
    tertiary = Color(0xFF4ADE80),
    onTertiary = Color(0xFF052E16),
    tertiaryContainer = Color(0xFF166534),
    onTertiaryContainer = Color(0xFFDCFCE7),
    background = UniConnectDarkBackground,
    onBackground = UniConnectDarkText,
    surface = UniConnectDarkSurface,
    onSurface = UniConnectDarkText,
    surfaceVariant = UniConnectDarkSurfaceVariant,
    onSurfaceVariant = UniConnectDarkTextSecondary,
    outline = UniConnectDarkOutline,
    error = Color(0xFFF87171),
    onError = Color(0xFF450A0A),
    errorContainer = Color(0xFF7F1D1D),
    onErrorContainer = Color(0xFFFEE2E2),
)

@Composable
fun UniConnectTheme(
    darkTheme: Boolean = androidx.compose.foundation.isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = UniConnectTypography,
        shapes = UniConnectShapes,
        content = content,
    )
}
