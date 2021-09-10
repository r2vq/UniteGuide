package ca.keaneq.uniteguide.repo

import ca.keaneq.uniteguide.api.model.PokemonEvolutionResponse
import ca.keaneq.uniteguide.api.model.PokemonResponse
import ca.keaneq.uniteguide.api.model.PokemonSingleMoveResponse
import ca.keaneq.uniteguide.repo.model.Evolution
import ca.keaneq.uniteguide.repo.model.Pokemon
import ca.keaneq.uniteguide.repo.model.SingleMove

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