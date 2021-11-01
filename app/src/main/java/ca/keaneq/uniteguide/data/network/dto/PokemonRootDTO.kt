package ca.keaneq.uniteguide.data.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonRootDTO(
    @Json(name = "pokemon") val pokemon: List<PokemonDTO>
)
