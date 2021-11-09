package ca.keaneq.domain.model

import ca.keaneq.network.dto.PokemonMovesetUpgradesDTO

data class Upgrade(
    val name: String,
    val cooldown: String,
    val description: String,
    val image: String
)

fun PokemonMovesetUpgradesDTO.toUpgrade() = Upgrade(
    name = name,
    cooldown = cooldown,
    description = description,
    image = image,
)
