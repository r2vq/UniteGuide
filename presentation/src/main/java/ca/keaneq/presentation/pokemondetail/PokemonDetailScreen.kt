package ca.keaneq.presentation.pokemondetail

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.presentation.pokemondetail.component.Content
import ca.keaneq.presentation.pokemondetail.viewmodel.PokemonDetailViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val pokemon = state.pokemon
    when {
        pokemon != null -> {
            Content(
                pokemonState = pokemon,
                onMoveClick = viewModel::onMoveClick
            )
        }
        state.isLoading -> {
            Text(text = "Loading")
        }
        !state.error.isNullOrBlank() -> {
            Text(text = "Error: ${state.error}")
        }
    }
}
