package ca.keaneq.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonMovesetDTO(
    @Json(name = "basic") val basic: PokemonMovesetBasicDTO,
    @Json(name = "upgrades") val upgrades: List<PokemonMovesetUpgradesDTO>,
)
