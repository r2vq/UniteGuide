package ca.keaneq.uniteguide.domain.usecase

import ca.keaneq.repository.Repository
import ca.keaneq.uniteguide.common.Resource
import ca.keaneq.uniteguide.domain.model.PokemonItem
import ca.keaneq.uniteguide.domain.model.toPokemonItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Resource<List<PokemonItem>>> = flow {
        try {
            emit(Resource.Loading<List<PokemonItem>>())
            repository.getPokemonList()
                .map { pokemonList -> pokemonList.toPokemonItem() }
                .let { pokemonList -> emit(Resource.Success(pokemonList)) }
        } catch (e: HttpException) {
            emit(Resource.Error<List<PokemonItem>>(e.message() ?: "An unknown network error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<PokemonItem>>(e.message ?: "An unknown IO error occurred. Do you have Internet?"))
        } catch (e: Exception) {
            emit(Resource.Error<List<PokemonItem>>(e.message ?: "An unknown error occurred."))
        }
    }
}