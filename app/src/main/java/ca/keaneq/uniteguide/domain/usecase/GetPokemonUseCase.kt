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

class GetPokemonUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(id: String): Flow<Resource<PokemonItem>> = flow {
        try {
            emit(Resource.Loading<PokemonItem>())
            val emission = repository.getPokemon(id)
                ?.toPokemonItem()
                ?.let { pokemon -> Resource.Success<PokemonItem>(pokemon) }
                ?: run { Resource.Error<PokemonItem>("No matching Pokémon found") }
            emit(emission)
        } catch (e: HttpException) {
            emit(Resource.Error<PokemonItem>(e.message() ?: "An unknown network error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error<PokemonItem>(
                    e.message ?: "An unknown IO error occurred. Do you have Internet?"
                )
            )
        } catch (e: Exception) {
            emit(Resource.Error<PokemonItem>(e.message ?: "An unknown error occurred."))
        }
    }
}