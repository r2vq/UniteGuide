package ca.keaneq.uniteguide.presentation.pokemondetail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.uniteguide.presentation.pokemondetail.component.PokemonImage
import ca.keaneq.uniteguide.presentation.pokemondetail.viewmodel.PokemonDetailViewModel

@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    when {
        state.pokemon != null -> {
            PokemonImage(pokemon = state.pokemon)
        }
        state.isLoading -> {
            Text(text = "Loading")
        }
        state.error.isNotBlank() -> {
            Text(text = "Error: ${state.error}")
        }
    }
}