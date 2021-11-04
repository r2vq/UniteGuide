package ca.keaneq.uniteguide.presentation.model

import ca.keaneq.domain.model.*

data class PokemonItem(
    val id: String,
    val name: String,
    val imageUrl: String?,
    val role: RoleItem,
    val attackType: AttackTypeItem,
    val lane: LaneItem,
    val difficulty: DifficultyItem,
    val attackStyle: AttackStyleItem,
    val evolutions: List<EvolutionItem>,
)

fun Pokemon.toPokemonItem(): PokemonItem = PokemonItem(
    id = id,
    name = name,
    imageUrl = imageUrl,
    role = when (role) {
        Role.ALL_ROUNDER -> RoleItem.ALL_ROUNDER
        Role.ATTACKER -> RoleItem.ATTACKER
        Role.DEFENDER -> RoleItem.DEFENDER
        Role.SPEEDSTER -> RoleItem.SPEEDSTER
        Role.SUPPORTER -> RoleItem.SUPPORTER
        Role.UNSPECIFIED -> RoleItem.UNSPECIFIED
    },
    attackType = when (attackType) {
        AttackType.PHYSICAL -> AttackTypeItem.PHYSICAL
        AttackType.SPECIAL -> AttackTypeItem.SPECIAL
        AttackType.UNSPECIFIED -> AttackTypeItem.UNSPECIFIED
    },
    lane = when (lane) {
        Lane.TOP -> LaneItem.TOP
        Lane.CENTER -> LaneItem.CENTER
        Lane.BOTTOM -> LaneItem.BOTTOM
        Lane.UNSPECIFIED -> LaneItem.UNSPECIFIED
    },
    difficulty = when (difficulty) {
        Difficulty.NOVICE -> DifficultyItem.NOVICE
        Difficulty.INTERMEDIATE -> DifficultyItem.INTERMEDIATE
        Difficulty.EXPERT -> DifficultyItem.EXPERT
        Difficulty.UNSPECIFIED -> DifficultyItem.UNSPECIFIED
    },
    attackStyle = when (attackStyle) {
        AttackStyle.MELEE -> AttackStyleItem.MELEE
        AttackStyle.RANGED -> AttackStyleItem.RANGED
        AttackStyle.UNSPECIFIED -> AttackStyleItem.UNSPECIFIED
    },
    evolutions = evolutions.map { evolution -> evolution.toEvolutionItem() },
)