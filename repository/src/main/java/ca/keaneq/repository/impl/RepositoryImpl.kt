package ca.keaneq.repository.impl

import ca.keaneq.network.PokeClient
import ca.keaneq.repository.Repository
import ca.keaneq.repository.mapper.toEntity
import ca.keaneq.repository.model.PokemonEntity
import ca.keaneq.repository.model.Resource
import ca.keaneq.network.model.Resource as NetworkResource

internal class RepositoryImpl constructor(
    private val client: PokeClient
) : Repository {

    override suspend fun getPokemonList(): Resource<List<PokemonEntity>> = client
        .getPokemon()
        .let { resource ->
            if (resource is NetworkResource.Success) {
                resource.data
                    ?.pokemon
                    ?.map { pokemon -> pokemon.toEntity() }
                    .let { Resource.Success(it ?: emptyList()) }
            } else {
                Resource.Error(exception = resource.exception)
            }
        }
}