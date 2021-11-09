package ca.keaneq.repository.model

import ca.keaneq.network.dto.PokemonSingleMoveDTO

data class PokemonMoveEntity(
    val image: String,
    val name: String,
    val description: String
)

fun PokemonSingleMoveDTO.toEntity() = PokemonMoveEntity(
    image = image,
    name = name,
    description = description,
)
