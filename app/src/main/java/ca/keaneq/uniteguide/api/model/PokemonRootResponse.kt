package ca.keaneq.uniteguide.api.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonRootResponse(
    @Json(name = "pokemon") val pokemon: List<PokemonResponse>,
)