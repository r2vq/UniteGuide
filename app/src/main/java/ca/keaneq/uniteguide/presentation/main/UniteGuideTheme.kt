package ca.keaneq.uniteguide.presentation.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun UniteGuideTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (isDarkMode) Colors.DarkColors else Colors.LightColors,
        content = content,
        typography = typography,
    )
}

private val typography = Typography(
    h1 = TextStyle(
        fontSize = 16.sp,
    ),
    subtitle1 = TextStyle(
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontSize = 12.sp,
    ),
)

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
    val GRAY_900 = Color(0xFF111111)
    val BLUE_GRAY_200 = Color(0xFFB0BEC5)
    val GRAY_50 = Color(0xFFEBEBEB)

    val DarkColors = darkColors(
        primary = DEEP_PURPLE_A700,
        primaryVariant = DEEP_PURPLE_A700_DARK,
        onPrimary = WHITE,
        secondary = ORANGE_700,
        secondaryVariant = ORANGE_700,
        onSecondary = BLACK,
        background = BLACK,
        onBackground = WHITE,
        surface = GRAY_900,
        onSurface = WHITE,
    )
    val LightColors = lightColors(
        primary = DEEP_PURPLE_A700,
        primaryVariant = DEEP_PURPLE_A700,
        onPrimary = WHITE,
        secondary = ORANGE_700,
        secondaryVariant = ORANGE_700,
        onSecondary = BLACK,
        background = GRAY_50,
        onBackground = BLACK,
        surface = WHITE,
        onSurface = BLACK,
    )
}