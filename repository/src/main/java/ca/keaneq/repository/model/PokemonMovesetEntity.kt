package ca.keaneq.repository.model

import ca.keaneq.network.dto.PokemonMovesetDTO

data class PokemonMovesetEntity(
    val basic: PokemonMovesetBasicEntity,
    val upgrades: List<PokemonUpgradeEntity>,
)

fun PokemonMovesetDTO.toEntity() = PokemonMovesetEntity(
    basic = basic.toEntity(),
    upgrades = upgrades.map { it.toEntity() }
)