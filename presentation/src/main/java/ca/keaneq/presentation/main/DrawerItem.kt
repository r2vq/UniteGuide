package ca.keaneq.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.MaterialTheme
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ca.keaneq.presentation.R
import ca.keaneq.presentation.main.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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
    ABOUT(
        text = R.string.title_about,
        icon = R.drawable.ic_info_black_24dp,
        screen = Screen.About,
    ),
}

@Composable
fun DrawerItem.ToNavigationDrawerItem(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    scope: CoroutineScope = rememberCoroutineScope()
) {
    NavigationDrawerItem(
        text = stringResource(id = text),
        icon = icon,
        backgroundColor = MaterialTheme.colors.background,
        foregroundColor = MaterialTheme.colors.onBackground,
        onClick = {
            navController.navigate(screen.route) {
                launchSingleTop = true
                popUpTo(screen.route)
            }
            scope.launch { drawerState.close() }
        }
    )
}

@Preview
@Composable
fun DrawerItemPreview() {
    DrawerItem.POKEMON.ToNavigationDrawerItem()
}