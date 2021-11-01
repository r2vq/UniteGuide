package ca.keaneq.repository

import ca.keaneq.network.dto.PokemonDTO

interface Repository {
    /**
     * Get a specific Pokémon DTO.
     *
     * @param id The ID of the desired Pokémon.
     * @return The Pokémon or `null` if not found.
     * */
    suspend fun getPokemon(id: String): PokemonDTO?

    /**
     * Get the list of Pokémon DTO.
     *
     * @return A list of Pokémon.
     */
    suspend fun getPokemonList(): List<PokemonDTO>
}