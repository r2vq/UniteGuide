package ca.keaneq.uniteguide.api.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonMovesetResponse(
    @Json(name = "basic") val basic: PokemonMovesetBasicResponse
)
