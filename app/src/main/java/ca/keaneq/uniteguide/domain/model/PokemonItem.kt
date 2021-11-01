package ca.keaneq.uniteguide.domain.model

import ca.keaneq.uniteguide.data.network.dto.PokemonDTO

data class PokemonItem(
    val id: String,
    val name: String,
    val imageUrl: String?,
    val role: Role
)

fun PokemonDTO.toPokemonItem(): PokemonItem = PokemonItem(
    id = id,
    name = name,
    imageUrl = image,
    role = when (role) {
        "allrounder" -> Role.ALL_ROUNDER
        "attacker" -> Role.ATTACKER
        "defender" -> Role.DEFENDER
        "speedster" -> Role.SPEEDSTER
        "supporter" -> Role.SUPPORTER
        else -> Role.UNSPECIFIED
    },
)