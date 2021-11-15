package ca.keaneq.domain.model

import ca.keaneq.repository.model.HeldItemStatDetailEntity

data class HeldItemStatDetail(
    val level: String,
    val description: String,
)

fun HeldItemStatDetailEntity.toDomain() = HeldItemStatDetail(
    level = level,
    description = description,
)