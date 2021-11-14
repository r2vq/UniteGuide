package ca.keaneq.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonStarsDTO(
    @Json(name = "offense") val offense: Float,
    @Json(name = "endurance") val endurance: Float,
    @Json(name = "mobility") val mobility: Float,
    @Json(name = "scoring") val scoring: Float,
    @Json(name = "support") val support: Float,
)