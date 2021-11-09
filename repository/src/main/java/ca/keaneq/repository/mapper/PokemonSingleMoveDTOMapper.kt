@file:JvmName("PokemonMovesetBasicDTOMapperKt")

package ca.keaneq.repository.mapper

import ca.keaneq.network.dto.PokemonSingleMoveDTO
import ca.keaneq.repository.model.PokemonMoveEntity

internal fun PokemonSingleMoveDTO.toEntity() = PokemonMoveEntity(
    image = image,
    name = name,
    description = description,
)
