package ca.keaneq.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class HeldItemStatDTO(
    @Json(name = "name") val name: String,
    @Json(name = "detail") val detail: List<HeldItemStatDetailDTO>
)
