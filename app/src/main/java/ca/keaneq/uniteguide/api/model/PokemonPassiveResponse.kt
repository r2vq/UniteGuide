package ca.keaneq.uniteguide.api.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonPassiveResponse(
    @Json(name = "image") val image: String,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String
)
