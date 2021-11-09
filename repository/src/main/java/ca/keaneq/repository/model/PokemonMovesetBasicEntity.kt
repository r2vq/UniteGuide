package ca.keaneq.repository.model

import ca.keaneq.network.dto.PokemonMovesetBasicDTO

data class PokemonMovesetBasicEntity(
    val name: String,
    val cooldown: String,
    val description: String,
    val image: String,
    val upgrade: Int,
)

fun PokemonMovesetBasicDTO.toEntity() = PokemonMovesetBasicEntity(
    name = name,
    cooldown = cooldown,
    description = description,
    image = image,
    upgrade = upgrade,
)
