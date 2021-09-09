package ca.keaneq.uniteguide.repo

import ca.keaneq.uniteguide.repo.model.Pokemon

interface PokemonRepository {
    /**
     * Retrieves all the Pokémon that the user can play as.
     */
    suspend fun getPokemon(): List<Pokemon>

    /**
     * Retrieves the Pokémon with the matching ID. Returns null if ID is not found.
     */
    suspend fun getPokemon(id: String): Pokemon?
}