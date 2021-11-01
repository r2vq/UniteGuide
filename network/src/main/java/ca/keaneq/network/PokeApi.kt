package ca.keaneq.network

import ca.keaneq.network.dto.PokemonRootDTO
import retrofit2.http.GET

interface PokeApi {
    @GET("pkmn.json")
    suspend fun getPokemon(): PokemonRootDTO
}