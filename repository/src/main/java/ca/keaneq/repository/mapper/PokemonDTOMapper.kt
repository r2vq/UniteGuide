package ca.keaneq.repository.mapper

import ca.keaneq.network.dto.PokemonDTO
import ca.keaneq.repository.model.PokemonEntity
import ca.keaneq.repository.model.toEntity

internal fun PokemonDTO.toEntity() = PokemonEntity(
    id = id,
    name = name,
    difficulty = difficulty,
    style = style,
    role = role,
    lane = lane,
    attackType = attackType,
    stars = stars.toEntity(),
    image = image,
    evolutions = evolutions.map { evolution ->
        evolution.toEntity()
    },
    moveset = moveset.map { moveset ->
        moveset.toEntity()
    },
    passive = passive.toEntity(),
    basic = basic.toEntity(),
    unite = unite.toEntity(),
)