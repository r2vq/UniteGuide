package ca.keaneq.uniteguide.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ca.keaneq.uniteguide.presentation.about.AboutScreen
import ca.keaneq.uniteguide.presentation.pokemondetail.PokemonDetailScreen
import ca.keaneq.uniteguide.presentation.pokemonlist.PokemonListScreen

const val ARG_POKEMON_ID = "pokemonId"

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    onNavigationChange: (ToolbarState) -> Unit = {},
) {
    NavHost(navController = navController, startDestination = Screen.PokemonList.route) {
        composable(
            route = Screen.PokemonList.route,
        ) {
            onNavigationChange(ToolbarState.Menu)
            PokemonListScreen(navController = navController)
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
            onNavigationChange(ToolbarState.Up)
            PokemonDetailScreen()
        }
        composable(
            route = Screen.About.route,
        ) {
            onNavigationChange(ToolbarState.Menu)
            AboutScreen()
        }
    }
}