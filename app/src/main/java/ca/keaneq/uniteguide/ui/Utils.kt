package ca.keaneq.uniteguide.ui

import androidx.annotation.AttrRes
import androidx.annotation.StringRes
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.repo.model.Evolution
import ca.keaneq.uniteguide.repo.model.Moveset
import ca.keaneq.uniteguide.repo.model.Pokemon
import ca.keaneq.uniteguide.ui.model.*

const val DIFFICULTY_NOVICE = "novice"
const val DIFFICULTY_INTERMEDIATE = "intermediate"
const val DIFFICULTY_EXPERT = "expert"

const val LANE_TOP = "top"
const val LANE_CENTER = "center"
const val LANE_BOTTOM = "bottom"

const val ROLE_ATTACKER = "attacker"
const val ROLE_DEFENDER = "defender"
const val ROLE_SPEEDSTER = "speedster"
const val ROLE_SUPPORTER = "supporter"
const val ROLE_ALL_ROUNDER = "allrounder"

const val STYLE_MELEE = "melee"
const val STYLE_RANGED = "ranged"

const val TYPE_PHYSICAL = "physical"
const val TYPE_SPECIAL = "special"

fun Pokemon.pokemonToListItemPokemon(): ListItemPokemon = ListItemPokemon(
    id = id,
    name = name,
    backgroundColor = getRoleColor(),
    textColor = getRoleTextColor(),
    image = image
)

fun Pokemon.pokemonToTitle(id: String): ListItemTitle = ListItemTitle(
    id = id,
    text = name,
    backgroundColor = getRoleColor(),
    textColor = getRoleTextColor(),
)

fun Pokemon.pokemonToImage(id: String): ListItemImage = ListItemImage(
    id = id,
    imageUrl = image,
    backgroundColor = getRoleColor(),
)

fun Pokemon.pokemonToChips(id: String): ListItemChips = ListItemChips(
    id = id,
    leftChip = ListItemChips.Chip(
        backgroundColor = getRoleColor(),
        textColor = getRoleTextColor(),
        text = getRoleName()
    ),
    rightChip = ListItemChips.Chip(
        backgroundColor = getStyleColor(),
        textColor = getStyleTextColor(),
        text = getStyleName()
    ),
)

fun Pokemon.pokemonToFacts(id: String): ListItemFacts = ListItemFacts(
    id = id,
    leftFact = getAttackType(),
    centerFact = getLane(),
    rightFact = getDifficulty()
)

fun Pokemon.pokemonToEvolution(id: String): ListItemEvolutions = ListItemEvolutions(
    id = id,
    species = evolutions.map(Evolution::evolutionToSpecies)
)

fun Evolution.evolutionToSpecies() = ListItemEvolutions.Species(
    name = name,
    level = level,
    image = image
)

fun Moveset.pokemonToMoveAbility(id: String): ListItemMoveAbilityCompressed {
    val upgrade1 = upgrades.getOrNull(0)
    val upgrade2 = upgrades.getOrNull(1)
    return ListItemMoveAbilityCompressed(
        id = id,
        image = basic.image,
        name = basic.name,
        description = basic.description,
        cooldown = basic.cooldown,
        upgrade = basic.upgrade,
        upgrade1Name = upgrade1?.name,
        upgrade1Description = upgrade1?.description,
        upgrade1Cooldown = upgrade1?.cooldown,
        upgrade1Image = upgrade1?.image,
        upgrade2Name = upgrade2?.name,
        upgrade2Description = upgrade2?.description,
        upgrade2Cooldown = upgrade2?.cooldown,
        upgrade2Image = upgrade2?.image,
    )
}

fun Pokemon.pokemonToPassive(id: String) = ListItemMoveSingleCompressed(
    id = id,
    image = passive.image,
    name = passive.name,
    description = passive.description
)

fun Pokemon.pokemonToUnite(id: String) = ListItemMoveSingleCompressed(
    id = id,
    image = unite.image,
    name = unite.name,
    description = unite.description
)

fun Pokemon.pokemonToBasic(id: String) = ListItemMoveSingleCompressed(
    id = id,
    image = basic.image,
    name = basic.name,
    description = basic.description
)

@AttrRes
fun Pokemon.getRoleColor(): Int? = when (role) {
    ROLE_ATTACKER -> R.attr.colorAttacker
    ROLE_DEFENDER -> R.attr.colorDefender
    ROLE_SPEEDSTER -> R.attr.colorSpeedster
    ROLE_SUPPORTER -> R.attr.colorSupporter
    ROLE_ALL_ROUNDER -> R.attr.colorAllRounder
    else -> null
}

@AttrRes
fun Pokemon.getRoleTextColor(): Int? = when (role) {
    ROLE_ATTACKER -> R.attr.colorOnAttacker
    ROLE_DEFENDER -> R.attr.colorOnDefender
    ROLE_SPEEDSTER -> R.attr.colorOnSpeedster
    ROLE_SUPPORTER -> R.attr.colorOnSupporter
    ROLE_ALL_ROUNDER -> R.attr.colorOnAllRounder
    else -> null
}

@StringRes
fun Pokemon.getRoleName(): Int? = when (role) {
    ROLE_ATTACKER -> R.string.role_attacker
    ROLE_DEFENDER -> R.string.role_defender
    ROLE_SPEEDSTER -> R.string.role_speedster
    ROLE_SUPPORTER -> R.string.role_supporter
    ROLE_ALL_ROUNDER -> R.string.role_all_rounder
    else -> null
}

@AttrRes
fun Pokemon.getStyleColor(): Int? = when (style) {
    STYLE_MELEE -> R.attr.colorMelee
    STYLE_RANGED -> R.attr.colorRanged
    else -> null
}

@AttrRes
fun Pokemon.getStyleTextColor(): Int? = when (style) {
    STYLE_MELEE -> R.attr.colorOnMelee
    STYLE_RANGED -> R.attr.colorOnRanged
    else -> null
}

@StringRes
fun Pokemon.getStyleName(): Int? = when (style) {
    STYLE_MELEE -> R.string.attack_style_melee
    STYLE_RANGED -> R.string.attack_style_ranged
    else -> null
}

@StringRes
fun Pokemon.getAttackType(): Int? = when (attackType) {
    TYPE_PHYSICAL -> R.string.attack_type_physical
    TYPE_SPECIAL -> R.string.attack_type_special
    else -> null
}

@StringRes
fun Pokemon.getLane(): Int? = when (lane) {
    LANE_TOP -> R.string.lane_top
    LANE_CENTER -> R.string.lane_center
    LANE_BOTTOM -> R.string.lane_bottom
    else -> null
}

@StringRes
fun Pokemon.getDifficulty(): Int? = when (difficulty) {
    DIFFICULTY_NOVICE -> R.string.difficulty_novice
    DIFFICULTY_INTERMEDIATE -> R.string.difficulty_intermediate
    DIFFICULTY_EXPERT -> R.string.difficulty_expert
    else -> null
}