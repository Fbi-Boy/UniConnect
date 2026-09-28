package com.fbi.uniconnect.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = UniConnectBlue,
    onPrimary = UniConnectOnBlue,
    primaryContainer = UniConnectBlueContainer,
    onPrimaryContainer = UniConnectOnBlueContainer,
)

private val DarkColors = darkColorScheme(
    primary = UniConnectBlueDark,
    onPrimary = UniConnectOnBlueDark,
    primaryContainer = UniConnectBlueDarkContainer,
    onPrimaryContainer = UniConnectOnBlueDarkContainer,
)

@Composable
fun UniConnectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = UniConnectTypography,
        content = content,
    )
}
