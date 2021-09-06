package ca.keaneq.uniteguide.api.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "difficulty") val difficulty: String,
    @Json(name = "style") val style: String,
    @Json(name = "role") val role: String,
    @Json(name = "attack_type") val attackType: String
)