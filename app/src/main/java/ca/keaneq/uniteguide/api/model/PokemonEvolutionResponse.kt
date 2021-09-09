package ca.keaneq.uniteguide.api.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonEvolutionResponse(
    @Json(name = "name") val name: String,
    @Json(name = "level") val level: Int,
    @Json(name = "image") val image: String
)
