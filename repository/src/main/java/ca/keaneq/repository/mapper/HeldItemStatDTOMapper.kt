package ca.keaneq.repository.mapper

import ca.keaneq.network.dto.HeldItemStatDTO
import ca.keaneq.repository.model.HeldItemStatEntity

fun HeldItemStatDTO.toEntity() = HeldItemStatEntity(
    name = name,
    detail = detail.map { statDetail -> statDetail.toEntity() }
)