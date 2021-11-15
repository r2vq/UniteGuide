package ca.keaneq.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class HeldItemStatDetailDTO(
    @Json(name = "level") val level: String,
    @Json(name = "description") val description: String,
)
