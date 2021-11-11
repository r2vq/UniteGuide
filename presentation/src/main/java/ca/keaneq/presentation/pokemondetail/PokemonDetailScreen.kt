package ca.keaneq.presentation.pokemondetail

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.domain.model.Pokemon
import ca.keaneq.presentation.model.color
import ca.keaneq.presentation.model.onColor
import ca.keaneq.presentation.pokemondetail.component.*
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
                pokemon = pokemon,
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
    pokemon: Pokemon,
) {
    var isPassiveExpanded by remember { mutableStateOf(false) }
    var isBasicExpanded by remember { mutableStateOf(false) }
    var isUniteExpanded by remember { mutableStateOf(false) }

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item { PokemonImage(pokemon = pokemon) }
        item { PokemonPillRow(pokemon = pokemon) }
        item { PokemonStats(pokemon = pokemon) }
        item { PokemonEvolutions(pokemon = pokemon) }
        item {
            Move(pokemon.passive, pokemon.role.color, pokemon.role.onColor, isPassiveExpanded) {
                isPassiveExpanded = !isPassiveExpanded
            }
        }
        item {
            Move(pokemon.basic, pokemon.role.color, pokemon.role.onColor, isBasicExpanded) {
                isBasicExpanded = !isBasicExpanded
            }
        }
        pokemon.moveset.forEach { moveset ->
            item { Moveset(moveset, pokemon.role.color, pokemon.role.onColor) }
        }
        item {
            Move(pokemon.unite, pokemon.role.color, pokemon.role.onColor, isUniteExpanded) {
                isUniteExpanded = !isUniteExpanded
            }
        }
    }
}