package ca.keaneq.network.impl

import ca.keaneq.network.PokeApi
import ca.keaneq.network.PokeClient
import ca.keaneq.network.dto.HeldItemsRootDTO
import ca.keaneq.network.dto.PokemonRootDTO
import ca.keaneq.network.model.Resource
import javax.inject.Inject

internal class PokeClientImpl @Inject constructor(
    private val api: PokeApi
) : PokeClient {
    override suspend fun getPokemon(): Resource<PokemonRootDTO> {
        val data = api.getPokemon()
        val body = data.body()
        return if (data.isSuccessful && body != null) {
            Resource.Success(data = body)
        } else if (data.isSuccessful) {
            Resource.Error(exception = Exception("Successful call but missing response body."))
        } else {
            Resource.Error(exception = Exception(data.message()))
        }
    }

    override suspend fun getHeldItems(): Resource<HeldItemsRootDTO> {
        val data = api.getHeldItems()
        val body = data.body()
        return if (data.isSuccessful && body != null) {
            Resource.Success(data = body)
        } else if (data.isSuccessful) {
            Resource.Error(exception = Exception("Successful call but missing response body."))
        } else {
            Resource.Error(exception = Exception(data.message()))
        }
    }
}