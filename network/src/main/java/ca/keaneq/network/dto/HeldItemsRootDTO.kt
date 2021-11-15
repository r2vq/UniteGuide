package ca.keaneq.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class HeldItemsRootDTO(
    @Json(name = "held_items")
    val items: List<HeldItemDTO>
)
