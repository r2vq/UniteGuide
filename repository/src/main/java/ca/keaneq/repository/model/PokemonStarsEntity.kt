package ca.keaneq.repository.model

import ca.keaneq.network.dto.PokemonStarsDTO

data class PokemonStarsEntity(
    val offense: Float,
    val endurance: Float,
    val mobility: Float,
    val scoring: Float,
    val support: Float,
)

fun PokemonStarsDTO.toEntity() = PokemonStarsEntity(
    offense = offense,
    endurance = endurance,
    mobility = mobility,
    scoring = scoring,
    support = support,
)