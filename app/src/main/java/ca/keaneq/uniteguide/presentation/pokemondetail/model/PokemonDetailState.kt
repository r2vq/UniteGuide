package ca.keaneq.uniteguide.presentation.pokemondetail.model

import ca.keaneq.uniteguide.presentation.model.PokemonItem

data class PokemonDetailState(
    val isLoading: Boolean = false,
    val pokemon: PokemonItem? = null,
    val error: String = "",
)