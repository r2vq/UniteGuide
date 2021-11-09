package ca.keaneq.repository.model

import ca.keaneq.network.dto.PokemonMovesetUpgradesDTO

data class PokemonUpgradeEntity(
    val name: String,
    val cooldown: String,
    val description: String,
    val image: String,
)

fun PokemonMovesetUpgradesDTO.toEntity() = PokemonUpgradeEntity(
    name = name,
    cooldown = cooldown,
    description = description,
    image = image,
)
