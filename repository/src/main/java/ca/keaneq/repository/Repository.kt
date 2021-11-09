package ca.keaneq.repository

import ca.keaneq.repository.model.PokemonEntity
import ca.keaneq.repository.model.Resource

interface Repository {

    /**
     * Get the list of Pokémon DTO.
     *
     * @return A list of Pokémon.
     */
    suspend fun getPokemonList(): Resource<List<PokemonEntity>>
}