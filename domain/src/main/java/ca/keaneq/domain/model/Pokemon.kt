package ca.keaneq.domain.model

import ca.keaneq.network.dto.PokemonDTO

data class Pokemon(
    val id: String,
    val name: String,
    val imageUrl: String?,
    val role: Role
)

fun PokemonDTO.toPokemon(): Pokemon = Pokemon(
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