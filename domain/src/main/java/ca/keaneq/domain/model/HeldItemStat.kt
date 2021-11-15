package ca.keaneq.domain.model

import ca.keaneq.repository.model.HeldItemStatEntity

data class HeldItemStat(
    val name: String,
    val detail: List<HeldItemStatDetail>,
)

fun HeldItemStatEntity.toDomain() = HeldItemStat(
    name = name,
    detail = detail.map { statDetail -> statDetail.toDomain() },
)