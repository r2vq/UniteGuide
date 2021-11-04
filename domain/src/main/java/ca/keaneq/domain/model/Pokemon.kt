package ca.keaneq.domain.model

import ca.keaneq.network.dto.PokemonDTO

data class Pokemon(
    val id: String,
    val name: String,
    val imageUrl: String?,
    val role: Role,
    val attackType: AttackType,
    val lane: Lane,
    val difficulty: Difficulty,
    val attackStyle: AttackStyle,
    val evolutions: List<Evolution>,
)

fun PokemonDTO.toPokemon(): Pokemon = Pokemon(
    id = id,
    name = name,
    imageUrl = image,
    role = when (role) {
        "allrounder" -> Role.ALL_ROUNDER
        "attacker" -> Role.ATTACKER
        "defender" -> Role.DEFENDER
        "speedster" -> Role.SPEEDSTER
        "supporter" -> Role.SUPPORTER
        else -> Role.UNSPECIFIED
    },
    attackType = when (attackType) {
        "physical" -> AttackType.PHYSICAL
        "special" -> AttackType.SPECIAL
        else -> AttackType.UNSPECIFIED
    },
    lane = when (lane) {
        "top" -> Lane.TOP
        "center" -> Lane.CENTER
        "bottom" -> Lane.BOTTOM
        else -> Lane.UNSPECIFIED
    },
    difficulty = when (difficulty) {
        "novice" -> Difficulty.NOVICE
        "intermediate" -> Difficulty.INTERMEDIATE
        "expert" -> Difficulty.EXPERT
        else -> Difficulty.UNSPECIFIED
    },
    attackStyle = when (style) {
        "melee" -> AttackStyle.MELEE
        "ranged" -> AttackStyle.RANGED
        else -> AttackStyle.UNSPECIFIED
    },
    evolutions = evolutions.map { pokemonEvolutionDTO ->
        pokemonEvolutionDTO.toEvolution()
    },
)