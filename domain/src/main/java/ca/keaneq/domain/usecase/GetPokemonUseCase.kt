package ca.keaneq.domain.usecase

import ca.keaneq.domain.model.Pokemon
import ca.keaneq.domain.model.Resource
import ca.keaneq.domain.model.toPokemon
import ca.keaneq.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import ca.keaneq.repository.model.Resource as RepoResource

class GetPokemonUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(id: String): Flow<Resource<Pokemon>> = flow {
        emit(Resource.Loading())
        val result = repository.getPokemonList()
        val emission = if (result is RepoResource.Success) {
            result
                .data
                ?.firstOrNull { pokemon -> pokemon.id == id }
                ?.toPokemon()
                ?.let { pokemon -> Resource.Success(pokemon) }
                ?: run { Resource.Error("No matching Pokémon found") }
        } else {
            Resource.Error(result.exception?.toString() ?: "Error occurred in use case.")
        }
        emit(emission)
    }
}