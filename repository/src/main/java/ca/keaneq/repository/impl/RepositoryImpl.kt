package ca.keaneq.repository.impl

import ca.keaneq.network.PokeClient
import ca.keaneq.network.dto.PokemonDTO
import ca.keaneq.repository.Repository
import ca.keaneq.repository.model.Resource
import ca.keaneq.network.model.Resource as NetworkResource

internal class RepositoryImpl constructor(
    private val client: PokeClient
) : Repository {

    override suspend fun getPokemonList(): Resource<List<PokemonDTO>> = client
        .getPokemon()
        .let { resource ->
            if (resource is NetworkResource.Success) {
                resource.data
                    ?.pokemon
                    .let { Resource.Success(it ?: emptyList()) }
            } else {
                Resource.Error(exception = resource.exception)
            }
        }
}