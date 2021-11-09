package ca.keaneq.domain.model

import ca.keaneq.repository.model.PokemonMoveEntity

data class Move(
    val image: String,
    val name: String,
    val description: String
)

fun PokemonMoveEntity.toMove(): Move = Move(
    image = image,
    name = name,
    description = description,
)
