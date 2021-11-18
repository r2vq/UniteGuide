package ca.keaneq.repository.mapper

import ca.keaneq.network.dto.HeldItemDTO
import ca.keaneq.repository.model.HeldItemEntity

fun HeldItemDTO.toEntity() = HeldItemEntity(
    name = name,
    id = id,
    image = image,
    upgrades = upgrades.map { upgrade -> upgrade.toEntity() },
    stats = stats.map { stat -> stat.toEntity() },
)