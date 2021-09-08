package ca.keaneq.uniteguide.repo

import ca.keaneq.uniteguide.api.model.PokemonResponse
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
    attackType = attackType,
    image = image
)