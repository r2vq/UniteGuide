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

class GetPokemonListUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Resource<List<Pokemon>>> = flow {
        try {
            emit(Resource.Loading<List<Pokemon>>())
            repository.getPokemonList()
                .map { pokemonList -> pokemonList.toPokemon() }
                .let { pokemonList -> emit(Resource.Success(pokemonList)) }
        } catch (e: HttpException) {
            emit(Resource.Error<List<Pokemon>>(e.message ?: "An unknown network error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error<List<Pokemon>>(
                    e.message ?: "An unknown IO error occurred. Do you have Internet?"
                )
            )
        } catch (e: Exception) {
            emit(Resource.Error<List<Pokemon>>(e.message ?: "An unknown error occurred."))
        }
    }
}