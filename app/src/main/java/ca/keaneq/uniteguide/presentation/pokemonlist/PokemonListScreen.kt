package ca.keaneq.uniteguide.presentation.pokemonlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ca.keaneq.uniteguide.presentation.navigation.Screen
import ca.keaneq.uniteguide.presentation.navigation.withArgs
import ca.keaneq.uniteguide.presentation.pokemonlist.component.PokemonListItem
import ca.keaneq.uniteguide.presentation.pokemonlist.viewmodel.PokemonListViewModel

@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel = hiltViewModel(),
    navController: NavController = rememberNavController(),
) {
    val state = viewModel.state.value
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(state.pokemon) { pokemon ->
            PokemonListItem(pokemon) {
                navController.navigate(Screen.PokemonDetail.withArgs(pokemon.id))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonScreenPreview() {
    PokemonListScreen()
}