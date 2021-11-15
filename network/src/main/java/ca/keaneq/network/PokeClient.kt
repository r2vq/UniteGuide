package ca.keaneq.network

import ca.keaneq.network.dto.HeldItemsRootDTO
import ca.keaneq.network.dto.PokemonRootDTO
import ca.keaneq.network.model.Resource

/**
 * A simple wrapper around the API that wraps the result in a Resource.
 */
interface PokeClient {

    /**
     * Make a call on the network to the API. Retrieve the response and return it.
     *
     * @return a [Resource.Success] if there's an error, or a [Resource.Error] otherwise.
     */
    suspend fun getPokemon(): Resource<PokemonRootDTO>

    /**
     * Make a call on the network to the API. Retrieve the response and return it.
     *
     * @return a [Resource.Success] if there's an error, or a [Resource.Error] otherwise.
     */
    suspend fun getHeldItems(): Resource<HeldItemsRootDTO>
}