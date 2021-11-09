package ca.keaneq.repository.mapper

import ca.keaneq.network.dto.PokemonMovesetBasicDTO
import ca.keaneq.repository.model.PokemonMovesetBasicEntity

internal fun PokemonMovesetBasicDTO.toEntity() = PokemonMovesetBasicEntity(
    name = name,
    cooldown = cooldown,
    description = description,
    image = image,
    upgrade = upgrade,
)