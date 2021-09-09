package ca.keaneq.uniteguide.repo

import ca.keaneq.uniteguide.api.model.PokemonEvolutionResponse
import ca.keaneq.uniteguide.api.model.PokemonResponse
import ca.keaneq.uniteguide.repo.model.Evolution
import ca.keaneq.uniteguide.repo.model.Pokemon

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
    evolutions = evolutions.map(PokemonEvolutionResponse::toEvolution)
)

/**
 * Util to convert from PokemonEvolutionResponse to Evolution.
 */
fun PokemonEvolutionResponse.toEvolution(): Evolution = Evolution(
    name = name,
    level = level,
    image = image
)