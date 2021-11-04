package ca.keaneq.uniteguide.presentation.pokemondetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.uniteguide.presentation.pokemondetail.component.PillFilled
import ca.keaneq.uniteguide.presentation.pokemondetail.component.PillOutlined
import ca.keaneq.uniteguide.presentation.pokemondetail.component.PokemonImage
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
                Row {
                    PillFilled(
                        text = "Attacker",
                        color = pokemon.role.color(),
                        onColor = pokemon.role.onColor(),
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    PillOutlined(
                        text = "Ranged",
                        color = pokemon.role.onColor(),
                        onColor = pokemon.role.color(),
                    )
                }
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