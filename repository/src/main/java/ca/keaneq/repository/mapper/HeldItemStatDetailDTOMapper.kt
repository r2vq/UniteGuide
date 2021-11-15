package ca.keaneq.repository.mapper

import ca.keaneq.network.dto.HeldItemStatDetailDTO
import ca.keaneq.repository.model.HeldItemStatDetailEntity

fun HeldItemStatDetailDTO.toEntity() = HeldItemStatDetailEntity(
    level = level,
    description = description,
)