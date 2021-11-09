package ca.keaneq.domain.model

import ca.keaneq.repository.model.PokemonEvolutionEntity

data class Evolution(
    val name: String,
    val level: Int,
    val image: String,
)

fun PokemonEvolutionEntity.toEvolution(): Evolution = Evolution(
    name = name,
    level = level,
    image = image,
)