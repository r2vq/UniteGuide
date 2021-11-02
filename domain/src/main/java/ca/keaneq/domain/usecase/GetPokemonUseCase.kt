package ca.keaneq.domain.usecase

import ca.keaneq.domain.model.Pokemon
import ca.keaneq.domain.model.Resource
import ca.keaneq.domain.model.toPokemon
import ca.keaneq.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(id: String): Flow<Resource<Pokemon>> = flow {
        try {
            emit(Resource.Loading<Pokemon>())
            val emission = repository.getPokemon(id)
                ?.toPokemon()
                ?.let { pokemon -> Resource.Success<Pokemon>(pokemon) }
                ?: run { Resource.Error<Pokemon>("No matching Pokémon found") }
            emit(emission)
        } catch (e: HttpException) {
            emit(Resource.Error<Pokemon>(e.message() ?: "An unknown network error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error<Pokemon>(
                    e.message ?: "An unknown IO error occurred. Do you have Internet?"
                )
            )
        } catch (e: Exception) {
            emit(Resource.Error<Pokemon>(e.message ?: "An unknown error occurred."))
        }
    }
}