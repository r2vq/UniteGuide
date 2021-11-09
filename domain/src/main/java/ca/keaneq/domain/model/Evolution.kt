package ca.keaneq.domain.model

// this should be in the repo
import ca.keaneq.network.dto.PokemonEvolutionDTO

data class Evolution(
    val name: String,
    val level: Int,
    val image: String,
)

fun PokemonEvolutionDTO.toEvolution(): Evolution = Evolution(
    name = name,
    level = level,
    image = image,
)