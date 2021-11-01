package ca.keaneq.uniteguide.presentation.pokemonlist.model

import ca.keaneq.uniteguide.domain.model.PokemonItem

data class PokemonListState(
    val isLoading: Boolean = false,
    val pokemon: List<PokemonItem> = emptyList(),
    val error: String = "",
)