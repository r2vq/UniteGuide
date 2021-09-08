package ca.keaneq.uniteguide.api

import ca.keaneq.uniteguide.api.model.PokemonRootResponse
import retrofit2.http.GET

interface PokeApi {
    @GET("pkmn.json")
    suspend fun getPokemon(): PokemonRootResponse

    companion object {
        const val BASE_URL = "https://r2vq.github.io/unite/"
    }
}