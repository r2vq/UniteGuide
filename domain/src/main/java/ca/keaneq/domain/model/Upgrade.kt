package ca.keaneq.domain.model

import ca.keaneq.repository.model.PokemonUpgradeEntity

data class Upgrade(
    val name: String,
    val cooldown: String,
    val description: String,
    val image: String
)

fun PokemonUpgradeEntity.toUpgrade() = Upgrade(
    name = name,
    cooldown = cooldown,
    description = description,
    image = image,
)
