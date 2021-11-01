package ca.keaneq.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonMovesetUpgradesDTO(
    @Json(name = "name") val name: String,
    @Json(name = "cooldown") val cooldown: String,
    @Json(name = "description") val description: String,
    @Json(name = "image") val image: String,
)
