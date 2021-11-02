package ca.keaneq.network

import ca.keaneq.network.dto.PokemonRootDTO
import retrofit2.Response
import retrofit2.http.GET

internal interface PokeApi {
    @GET("pkmn.json")
    suspend fun getPokemon(): Response<PokemonRootDTO>
}