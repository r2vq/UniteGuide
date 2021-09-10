package ca.keaneq.uniteguide.repo

import ca.keaneq.uniteguide.api.model.*
import ca.keaneq.uniteguide.repo.model.*

/**
 * Util to convert from PokemonResponse to Pokemon.
 */
fun PokemonResponse.toPokemon(): Pokemon = Pokemon(
    id = id,
    name = name,
    difficulty = difficulty,
    style = style,
    role = role,
    lane = lane,
    attackType = attackType,
    image = image,
    evolutions = evolutions.map(PokemonEvolutionResponse::toEvolution),
    moveset = moveset.map(PokemonMovesetResponse::toMoveset),
    passive = passive.toSingleMove(),
    basic = basic.toSingleMove(),
    unite = unite.toSingleMove()
)

/**
 * Util to convert from PokemonEvolutionResponse to Evolution.
 */
fun PokemonEvolutionResponse.toEvolution(): Evolution = Evolution(
    name = name,
    level = level,
    image = image
)

fun PokemonSingleMoveResponse.toSingleMove(): SingleMove = SingleMove(
    name = name,
    image = image,
    description = description,
)

fun PokemonMovesetResponse.toMoveset(): Moveset = Moveset(
    basic = basic.toBasic(),
    upgrades = upgrades.map(PokemonMovesetUpgradesResponse::toUpgrade)
)

fun PokemonMovesetBasicResponse.toBasic(): BasicMove = BasicMove(
    name = name,
    cooldown = cooldown,
    description = description,
    upgrade = upgrade,
    image = image,
)

fun PokemonMovesetUpgradesResponse.toUpgrade(): UpgradeMove = UpgradeMove(
    name = name,
    cooldown = cooldown,
    description = description,
    image = image,
)