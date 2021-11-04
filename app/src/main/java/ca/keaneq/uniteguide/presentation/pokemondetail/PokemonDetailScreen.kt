package ca.keaneq.uniteguide.presentation.pokemondetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.uniteguide.presentation.pokemondetail.component.PokemonImage
import ca.keaneq.uniteguide.presentation.pokemondetail.component.PokemonPillRow
import ca.keaneq.uniteguide.presentation.pokemondetail.component.PokemonStats
import ca.keaneq.uniteguide.presentation.pokemondetail.viewmodel.PokemonDetailViewModel

@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val pokemon = state.pokemon
    when {
        pokemon != null -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PokemonImage(pokemon = pokemon)
                PokemonPillRow(pokemon = pokemon)
                PokemonStats(pokemonItem = pokemon)
            }
        }
        state.isLoading -> {
            Text(text = "Loading")
        }
        state.error.isNotBlank() -> {
            Text(text = "Error: ${state.error}")
        }
    }
}