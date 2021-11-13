package ca.keaneq.presentation.pokemonlist.model

import ca.keaneq.domain.model.Pokemon

data class PokemonListState(
    val isLoading: Boolean = false,
    val pokemon: List<Pokemon> = emptyList(),
    val error: String = "",
)