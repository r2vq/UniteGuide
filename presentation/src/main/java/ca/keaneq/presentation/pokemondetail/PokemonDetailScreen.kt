package ca.keaneq.presentation.pokemondetail

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.presentation.model.color
import ca.keaneq.presentation.model.onColor
import ca.keaneq.presentation.pokemondetail.component.*
import ca.keaneq.presentation.pokemondetail.model.PokemonState
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

@Composable
private fun Content(
    pokemonState: PokemonState,
    onMoveClick: (Int) -> Unit,
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item { PokemonImage(pokemon = pokemonState.pokemon) }
        item { PokemonPillRow(pokemon = pokemonState.pokemon) }
        item { PokemonStats(pokemon = pokemonState.pokemon) }
        item { PokemonEvolutions(pokemon = pokemonState.pokemon) }
        pokemonState.moves.forEach { moveState ->
            item {
                Move(
                    moveState = moveState,
                    color = pokemonState.pokemon.role.color,
                    onColor = pokemonState.pokemon.role.onColor,
                    onClick = onMoveClick,
                )
            }
        }
    }
}