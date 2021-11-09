package ca.keaneq.repository.mapper

import ca.keaneq.network.dto.PokemonMovesetDTO
import ca.keaneq.repository.model.PokemonMovesetEntity

internal fun PokemonMovesetDTO.toEntity() = PokemonMovesetEntity(
    basic = basic.toEntity(),
    upgrades = upgrades.map { it.toEntity() }
)