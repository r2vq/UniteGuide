package ca.keaneq.domain.model

import ca.keaneq.repository.model.PokemonEntity

data class Pokemon(
    val id: String,
    val name: String,
    val imageUrl: String?,
    val role: Role,
    val attackType: AttackType,
    val lane: Lane,
    val difficulty: Difficulty,
    val attackStyle: AttackStyle,
    val stars: Stars,
    val evolutions: List<Evolution>,
    val passive: Move,
    val basic: Move,
    val unite: Move,
    val moveset: List<Moveset>,
)

fun PokemonEntity.toPokemon(): Pokemon = Pokemon(
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
    stars = Stars(
        offense = stars.offense,
        endurance = stars.endurance,
        mobility = stars.mobility,
        scoring = stars.scoring,
        support = stars.support,
    ),
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
    evolutions = evolutions.map { evolution ->
        evolution.toEvolution()
    },
    passive = passive.toMove(),
    basic = basic.toMove(),
    unite = unite.toMove(),
    moveset = moveset.map { moveset ->
        moveset.toMoveset()
    },
)