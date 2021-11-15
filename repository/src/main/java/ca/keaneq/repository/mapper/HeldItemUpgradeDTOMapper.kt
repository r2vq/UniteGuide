package ca.keaneq.repository.mapper

import ca.keaneq.network.dto.HeldItemUpgradeDTO
import ca.keaneq.repository.model.HeldItemUpgradeEntity

fun HeldItemUpgradeDTO.toEntity() = HeldItemUpgradeEntity(
    level = level,
    description = description,
    image = image,
)