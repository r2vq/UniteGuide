package ca.keaneq.repository

import ca.keaneq.repository.model.HeldItemEntity
import ca.keaneq.repository.model.PokemonEntity
import ca.keaneq.repository.model.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    /**
     * Get the list of Pokémon DTO.
     *
     * @return A list of Pokémon.
     */
    suspend fun getPokemonList(): Resource<List<PokemonEntity>>

    /**
     * Get the list of Held Items.
     *
     * @return A list of Held Items.
     */
    suspend fun getHeldItems(): Resource<List<HeldItemEntity>>

    /**
     * Set the [Int] that represents the current theme.
     */
    suspend fun setTheme(theme: Int)

    /**
     * Get the [Int] that represents the current theme.
     */
    fun getTheme(): Flow<Int>
}