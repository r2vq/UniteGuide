package ca.keaneq.uniteguide.presentation.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun UniteGuideTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (isDarkMode) Colors.DarkColors else Colors.LightColors,
        content = content
    )
}

private object Colors {
    val BLACK = Color(0xFF000000)
    val WHITE = Color(0xFFFFFFFF)
    val ORANGE_700 = Color(0xFFF57C00)
    val ORANGE_800 = Color(0xFFF06F2A)
    val GREEN_700 = Color(0xFF689F38)
    val LIGHT_BLUE_800 = Color(0xFF0277BD)
    val AMBER_300 = Color(0xFFFFD54F)
    val DEEP_PURPLE_A700 = Color(0xFF5427A0)
    val DEEP_PURPLE_A700_DARK = Color(0XFF0A00B6)
    val GRAY_800 = Color(0xFF424242)
    val GRAY_200 = Color(0xFF111111)
    val BLUE_GRAY_200 = Color(0xFFB0BEC5)

    val DarkColors = darkColors(
        primary = DEEP_PURPLE_A700,
        primaryVariant = DEEP_PURPLE_A700_DARK,
        onPrimary = WHITE,
        secondary = ORANGE_700,
        secondaryVariant = ORANGE_700,
        onSecondary = BLACK,
        background = BLACK,
        onBackground = WHITE,
        surface = GRAY_200,
        onSurface = WHITE,
    )
    val LightColors = lightColors(
        primary = DEEP_PURPLE_A700,
        primaryVariant = DEEP_PURPLE_A700,
        onPrimary = WHITE,
        secondary = ORANGE_700,
        secondaryVariant = ORANGE_700,
        onSecondary = BLACK,
        background = WHITE,
        onBackground = BLACK,
        surface = BLUE_GRAY_200,
        onSurface = BLACK,
    )
}