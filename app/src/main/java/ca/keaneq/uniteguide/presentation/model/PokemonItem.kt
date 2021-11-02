package ca.keaneq.uniteguide.presentation.model

import ca.keaneq.domain.model.Pokemon
import ca.keaneq.domain.model.Role

data class PokemonItem(
    val id: String,
    val name: String,
    val imageUrl: String?,
    val role: RoleItem
)

fun Pokemon.toPokemonItem(): PokemonItem = PokemonItem(
    id = id,
    name = name,
    imageUrl = imageUrl,
    role = when (role) {
        Role.ALL_ROUNDER -> RoleItem.ALL_ROUNDER
        Role.ATTACKER -> RoleItem.ATTACKER
        Role.DEFENDER -> RoleItem.DEFENDER
        Role.SPEEDSTER -> RoleItem.SPEEDSTER
        Role.SUPPORTER -> RoleItem.SUPPORTER
        Role.UNSPECIFIED -> RoleItem.UNSPECIFIED
    },
)