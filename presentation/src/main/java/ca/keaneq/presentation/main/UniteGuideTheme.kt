@file:Suppress("unused")

package ca.keaneq.presentation.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import ca.keaneq.domain.model.Theme

@Composable
fun UniteGuideTheme(
    theme: Theme,
    content: @Composable () -> Unit
) {
    val colors = when (theme) {
        Theme.Dark -> ThemeColors.DarkColors
        Theme.Light -> ThemeColors.LightColors
        Theme.System -> if (isSystemInDarkTheme()) ThemeColors.DarkColors else ThemeColors.LightColors
    }
    // TODO Add in crossfade here for better transition WHEN CROSSFADE DOESN'T BREAK BACKSTACK
    MaterialTheme(
        colors = colors,
        content = content,
        typography = typography,
    )
}

val Colors.allRounder: Color get() = ThemeColors.DEEP_PURPLE_A700
val Colors.attacker: Color get() = ThemeColors.RED_500
val Colors.defender: Color get() = ThemeColors.GREEN_800
val Colors.speedster: Color get() = ThemeColors.LIGHT_BLUE_800
val Colors.supporter: Color get() = ThemeColors.ORANGE_800
val Colors.unspecified: Color get() = ThemeColors.BLACK

val Colors.onPokemon: Color get() = ThemeColors.WHITE

private val typography = Typography(
    h1 = TextStyle(
        fontSize = 24.sp,
    ),
    h2 = TextStyle(
        fontSize = 16.sp,
    ),
    subtitle1 = TextStyle(
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontSize = 12.sp,
    ),
    body2 = TextStyle(
        fontSize = 14.sp,
    ),
)

private object ThemeColors {
    val BLACK = Color(0xFF000000)
    val WHITE = Color(0xFFFFFFFF)
    val RED_500 = Color(0xFFD32F2F)
    val ORANGE_700 = Color(0xFFF57C00)
    val ORANGE_800 = Color(0xFFF06F2A)
    val AMBER_300 = Color(0xFFFFD54F)
    val GREEN_700 = Color(0xFF689F38)
    val GREEN_800 = Color(0xFF2E7D32)
    val LIGHT_BLUE_800 = Color(0xFF0277BD)
    val DEEP_PURPLE_A700_DARK = Color(0XFF0A00B6)
    val DEEP_PURPLE_A700 = Color(0xFF5427A0)
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