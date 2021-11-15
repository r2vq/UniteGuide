package ca.keaneq.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class HeldItemUpgradeDTO(
    @Json(name = "level") val level: Int,
    @Json(name = "description") val description: String,
    @Json(name = "image") val image: String,
)
