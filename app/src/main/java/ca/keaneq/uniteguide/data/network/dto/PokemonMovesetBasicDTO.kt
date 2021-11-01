package ca.keaneq.uniteguide.data.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonMovesetBasicDTO(
    @Json(name = "name") val name: String,
    @Json(name = "cooldown") val cooldown: String,
    @Json(name = "description") val description: String,
    @Json(name = "image") val image: String,
    @Json(name = "upgrade") val upgrade: Int,
)
