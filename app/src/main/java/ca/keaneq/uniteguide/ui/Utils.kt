package ca.keaneq.uniteguide.ui

import android.graphics.Color
import ca.keaneq.uniteguide.repo.model.Pokemon
import ca.keaneq.uniteguide.ui.model.ListItemPokemon

const val COLOR_ATTACKER = "#a84c27"
const val COLOR_DEFENDER = "#74a03f"
const val COLOR_SPEEDSTER = "#1d709a"
const val COLOR_SUPPORTER = "#e6b849"
const val COLOR_ALL_ROUNDER = "#8a408f"

const val ROLE_ATTACKER = "attacker"
const val ROLE_DEFENDER = "defender"
const val ROLE_SPEEDSTER = "speedster"
const val ROLE_SUPPORTER = "supporter"
const val ROLE_ALL_ROUNDER = "allrounder"

fun Pokemon.pokemonToListItemPokemon(): ListItemPokemon = ListItemPokemon(
    id = id,
    name = name,
    backgroundColor = when (role) {
        ROLE_ATTACKER -> COLOR_ATTACKER
        ROLE_DEFENDER -> COLOR_DEFENDER
        ROLE_SPEEDSTER -> COLOR_SPEEDSTER
        ROLE_SUPPORTER -> COLOR_SUPPORTER
        ROLE_ALL_ROUNDER -> COLOR_ALL_ROUNDER
        else -> null
    }?.let { color -> Color.parseColor(color) },
    image = image
)