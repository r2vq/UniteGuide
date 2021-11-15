package ca.keaneq.domain.model

import ca.keaneq.repository.model.HeldItemUpgradeEntity

data class HeldItemUpgrade(
    val level: Int,
    val description: String,
    val image: String,
)

fun HeldItemUpgradeEntity.toDomain() = HeldItemUpgrade(
    level = level,
    description = description,
    image = image,
)