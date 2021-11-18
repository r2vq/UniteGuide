package ca.keaneq.presentation.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ca.keaneq.presentation.about.AboutScreen
import ca.keaneq.presentation.helditemdetail.HeldItemDetailScreen
import ca.keaneq.presentation.helditemlist.HeldItemListScreen
import ca.keaneq.presentation.pokemondetail.PokemonDetailScreen
import ca.keaneq.presentation.pokemonlist.PokemonListScreen
import ca.keaneq.presentation.settings.SettingsScreen

const val ARG_POKEMON_ID = "pokemonId"
const val ARG_HELD_ITEM_ID = "heldItemId"

@Composable
fun UniteGuideContent(
    navController: NavHostController = rememberNavController(),
    versionName: String = "",
    onChangeToolbarState: (ToolbarState) -> Unit = {},
    onNavigate: (route: String) -> Unit = {},
) {
    NavHost(
        navController = navController,
        startDestination = Screen.PokemonList.route
    ) {
        composable(
            route = Screen.PokemonList.route,
        ) {
            onChangeToolbarState(ToolbarState.Menu)
            PokemonListScreen(onNavigate = onNavigate)
        }
        composable(
            route = Screen.PokemonDetail.route + "/{$ARG_POKEMON_ID}",
            arguments = listOf(
                navArgument(ARG_POKEMON_ID) {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) {
            onChangeToolbarState(ToolbarState.Up)
            PokemonDetailScreen()
        }
        composable(
            route = Screen.About.route,
        ) {
            onChangeToolbarState(ToolbarState.Menu)
            AboutScreen(versionName)
        }
        composable(
            route = Screen.HeldItems.route,
        ) {
            onChangeToolbarState(ToolbarState.Menu)
            HeldItemListScreen(onNavigate = onNavigate)
        }
        composable(
            route = Screen.HeldItemDetail.route + "/{$ARG_HELD_ITEM_ID}",
            arguments = listOf(
                navArgument(ARG_HELD_ITEM_ID) {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) {
            onChangeToolbarState(ToolbarState.Up)
            HeldItemDetailScreen()
        }
        composable(
            route = Screen.Settings.route,
        ) {
            onChangeToolbarState(ToolbarState.Menu)
            SettingsScreen()
        }
    }
}