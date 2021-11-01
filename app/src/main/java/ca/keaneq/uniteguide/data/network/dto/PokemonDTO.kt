package ca.keaneq.uniteguide.data.network.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PokemonDTO(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "difficulty") val difficulty: String,
    @Json(name = "style") val style: String,
    @Json(name = "role") val role: String,
    @Json(name = "lane") val lane: String,
    @Json(name = "attack_type") val attackType: String,
    @Json(name = "image") val image: String?,
    @Json(name = "evolutions") val evolutions: List<PokemonEvolutionDTO>,
    @Json(name = "moveset") val moveset: List<PokemonMovesetDTO>,
    @Json(name = "passive") val passive: PokemonSingleMoveDTO,
    @Json(name = "basic") val basic: PokemonSingleMoveDTO,
    @Json(name = "unite") val unite: PokemonSingleMoveDTO
)
