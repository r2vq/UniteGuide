package ca.keaneq.uniteguide.presentation.navigation

sealed class Screen(val route: String) {
    object PokemonList : Screen("pokemon_list")
    object PokemonDetail : Screen("pokemon_detail")
    object About : Screen("about")
}

fun Screen.withArgs(vararg args: String): String = buildString {
    append(route)
    args.forEach { arg ->
        append("/$arg")
    }
}