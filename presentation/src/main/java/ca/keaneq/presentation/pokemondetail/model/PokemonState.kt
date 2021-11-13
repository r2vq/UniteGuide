package ca.keaneq.presentation.pokemondetail.model

import ca.keaneq.domain.model.Pokemon

data class PokemonState(
    val pokemon: Pokemon,
    val moves: List<MoveState>,
)