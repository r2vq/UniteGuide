package ca.keaneq.repository.model

import ca.keaneq.network.dto.PokemonDTO

data class PokemonEntity(
    val id: String,
    val name: String,
    val difficulty: String,
    val style: String,
    val role: String,
    val lane: String,
    val attackType: String,
    val image: String?,
    val evolutions: List<PokemonEvolutionEntity>,
    val moveset: List<PokemonMovesetEntity>,
    val passive: PokemonMoveEntity,
    val basic: PokemonMoveEntity,
    val unite: PokemonMoveEntity
)

fun PokemonDTO.toEntity() = PokemonEntity(
    id = id,
    name = name,
    difficulty = difficulty,
    style = style,
    role = role,
    lane = lane,
    attackType = attackType,
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