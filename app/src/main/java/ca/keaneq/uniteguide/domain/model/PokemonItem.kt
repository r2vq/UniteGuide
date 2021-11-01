package ca.keaneq.uniteguide.domain.model

import ca.keaneq.uniteguide.data.network.dto.PokemonDTO

data class PokemonItem(
    val name: String,
    val imageUrl: String?,
    val role: String
)

fun PokemonDTO.toPokemonItem(): PokemonItem = PokemonItem(
    name = name,
    imageUrl = image,
    role = role,
)