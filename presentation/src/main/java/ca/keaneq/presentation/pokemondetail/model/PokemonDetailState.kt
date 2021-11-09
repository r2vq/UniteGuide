package ca.keaneq.presentation.pokemondetail.model

import ca.keaneq.presentation.model.PokemonItem

data class PokemonDetailState(
    val isLoading: Boolean = false,
    val pokemon: PokemonItem? = null,
    val error: String = "",
)