package ca.keaneq.repository.model

import ca.keaneq.network.dto.PokemonEvolutionDTO

data class PokemonEvolutionEntity(
    val name: String,
    val level: Int,
    val image: String,
)

fun PokemonEvolutionDTO.toEntity() = PokemonEvolutionEntity(
    name = name,
    level = level,
    image = image,
)