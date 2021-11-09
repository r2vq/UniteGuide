package ca.keaneq.presentation.pokemonlist.model

import ca.keaneq.presentation.model.PokemonItem

data class PokemonListState(
    val isLoading: Boolean = false,
    val pokemon: List<PokemonItem> = emptyList(),
    val error: String = "",
)