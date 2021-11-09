package ca.keaneq.repository.mapper

import ca.keaneq.network.dto.PokemonMovesetUpgradesDTO
import ca.keaneq.repository.model.PokemonUpgradeEntity

internal fun PokemonMovesetUpgradesDTO.toEntity() = PokemonUpgradeEntity(
    name = name,
    cooldown = cooldown,
    description = description,
    image = image,
)