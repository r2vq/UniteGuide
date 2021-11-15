package ca.keaneq.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class HeldItemDTO(
    @Json(name = "name") val name: String,
    @Json(name = "image") val image: String,
    @Json(name = "upgrades") val upgrades: List<HeldItemUpgradeDTO>,
    @Json(name = "stats") val stats: List<HeldItemStatDTO>,
)
