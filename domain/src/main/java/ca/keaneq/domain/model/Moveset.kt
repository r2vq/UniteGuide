package ca.keaneq.domain.model

import ca.keaneq.repository.model.PokemonMovesetEntity

data class Moveset(
    val name: String,
    val cooldown: String,
    val description: String,
    val image: String,
    val upgrade: Int,
    val upgrades: List<Upgrade>
)

fun PokemonMovesetEntity.toMoveset() = Moveset(
    name = basic.name,
    cooldown = basic.cooldown,
    description = basic.description,
    image = basic.image,
    upgrade = basic.upgrade,
    upgrades = upgrades.map { upgrade ->
        upgrade.toUpgrade()
    },
)