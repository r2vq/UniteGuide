package ca.keaneq.repository.mapper

import ca.keaneq.network.dto.PokemonEvolutionDTO
import ca.keaneq.repository.model.PokemonEvolutionEntity

internal fun PokemonEvolutionDTO.toEntity() = PokemonEvolutionEntity(
    name = name,
    level = level,
    image = image,
)