package ca.keaneq.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ca.keaneq.presentation.R
import ca.keaneq.presentation.main.navigation.Screen

enum class DrawerItem(
    @StringRes val text: Int,
    @DrawableRes val icon: Int,
    val screen: Screen
) {
    POKEMON(
        text = R.string.title_pokemon,
        icon = R.drawable.ic_pokeball_black,
        screen = Screen.PokemonList,
    ),
    HELD_ITEM(
        text = R.string.title_held_items,
        icon = R.drawable.ic_held_items,
        screen = Screen.HeldItems,
    ),
    ABOUT(
        text = R.string.title_about,
        icon = R.drawable.ic_info_black_24dp,
        screen = Screen.About,
    ),
    SETTING(
        text = R.string.title_settings,
        icon = R.drawable.ic_gear,
        screen = Screen.Settings,
    )
}

@Composable
fun DrawerItem.ToNavigationDrawerItem(
    onNavigateAndCloseScaffold: (Screen) -> Unit = {},
) {
    NavigationDrawerItem(
        text = stringResource(id = text),
        icon = icon,
        backgroundColor = MaterialTheme.colors.background,
        foregroundColor = MaterialTheme.colors.onBackground,
        onClick = { onNavigateAndCloseScaffold(screen) }
    )
}

@Preview
@Composable
fun DrawerItemPreview() {
    DrawerItem.POKEMON.ToNavigationDrawerItem()
}