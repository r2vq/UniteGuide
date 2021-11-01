package ca.keaneq.uniteguide.data.network

import ca.keaneq.uniteguide.data.network.dto.PokemonRootDTO
import retrofit2.http.GET

interface PokeApi {
    @GET("pkmn.json")
    suspend fun getPokemon(): PokemonRootDTO
}