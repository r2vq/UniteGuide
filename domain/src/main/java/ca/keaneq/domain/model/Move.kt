package ca.keaneq.domain.model

import ca.keaneq.network.dto.PokemonSingleMoveDTO

data class Move(
    val image: String,
    val name: String,
    val description: String
)

fun PokemonSingleMoveDTO.toMove(): Move = Move(
    image = image,
    name = name,
    description = description,
)
