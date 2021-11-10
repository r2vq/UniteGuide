package ca.keaneq.presentation.pokemondetail.model

import ca.keaneq.domain.model.Pokemon

data class PokemonState(
    val isLoading: Boolean = false,
    val pokemon: Pokemon? = null,
    val error: String? = null
)
