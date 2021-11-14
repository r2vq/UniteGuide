package ca.keaneq.presentation.pokemonlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ca.keaneq.presentation.main.navigation.Screen
import ca.keaneq.presentation.main.navigation.withArgs
import ca.keaneq.presentation.pokemonlist.component.PokemonListItem
import ca.keaneq.presentation.pokemonlist.viewmodel.PokemonListViewModel

@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel = hiltViewModel(),
    navController: NavController = rememberNavController(),
) {
    val state = viewModel.state.value
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface),
    ) {
        itemsIndexed(state.pokemon) { i, pokemon ->
            PokemonListItem(
                pokemon = pokemon,
                isFirstItem = i == 0,
            ) {
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