package ca.keaneq.uniteguide.ui

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.repo.model.Pokemon
import ca.keaneq.uniteguide.ui.model.ListItemChips
import ca.keaneq.uniteguide.ui.model.ListItemImage
import ca.keaneq.uniteguide.ui.model.ListItemPokemon
import ca.keaneq.uniteguide.ui.model.ListItemTitle

const val COLOR_ATTACKER = "#f06f2a"
const val COLOR_DEFENDER = "#74a03f"
const val COLOR_SPEEDSTER = "#1d709a"
const val COLOR_SUPPORTER = "#e6b849"
const val COLOR_ALL_ROUNDER = "#5805d0"

const val COLOR_MELEE = "#333333"
const val COLOR_RANGED = "#5805d0"

const val ROLE_ATTACKER = "attacker"
const val ROLE_DEFENDER = "defender"
const val ROLE_SPEEDSTER = "speedster"
const val ROLE_SUPPORTER = "supporter"
const val ROLE_ALL_ROUNDER = "allrounder"

const val STYLE_MELEE = "melee"
const val STYLE_RANGED = "ranged"

fun Pokemon.pokemonToListItemPokemon(): ListItemPokemon = ListItemPokemon(
    id = id,
    name = name,
    backgroundColor = getRoleColor(),
    image = image
)

fun Pokemon.pokemonToTitle(id: String): ListItemTitle = ListItemTitle(
    id = id,
    text = name,
    backgroundColor = getRoleColor(),
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
        text = getRoleName()
    ),
    rightChip = ListItemChips.Chip(
        backgroundColor = getStyleColor(),
        text = getStyleName()
    ),
)

@ColorInt
fun Pokemon.getRoleColor(): Int? = when (role) {
    ROLE_ATTACKER -> COLOR_ATTACKER
    ROLE_DEFENDER -> COLOR_DEFENDER
    ROLE_SPEEDSTER -> COLOR_SPEEDSTER
    ROLE_SUPPORTER -> COLOR_SUPPORTER
    ROLE_ALL_ROUNDER -> COLOR_ALL_ROUNDER
    else -> null
}?.let { color -> Color.parseColor(color) }

@StringRes
fun Pokemon.getRoleName(): Int? = when (role) {
    ROLE_ATTACKER -> R.string.role_attacker
    ROLE_DEFENDER -> R.string.role_defender
    ROLE_SPEEDSTER -> R.string.role_speedster
    ROLE_SUPPORTER -> R.string.role_supporter
    ROLE_ALL_ROUNDER -> R.string.role_all_rounder
    else -> null
}

@ColorInt
fun Pokemon.getStyleColor(): Int? = when (style) {
    STYLE_MELEE -> COLOR_MELEE
    STYLE_RANGED -> COLOR_RANGED
    else -> null
}?.let { color -> Color.parseColor(color) }

@StringRes
fun Pokemon.getStyleName(): Int? = when (style) {
    STYLE_MELEE -> R.string.attack_style_melee
    STYLE_RANGED -> R.string.attack_style_ranged
    else -> null
}