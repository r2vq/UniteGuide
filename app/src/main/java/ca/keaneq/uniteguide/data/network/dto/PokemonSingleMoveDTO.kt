package ca.keaneq.uniteguide.data.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonSingleMoveDTO(
    @Json(name = "image") val image: String,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String
)
