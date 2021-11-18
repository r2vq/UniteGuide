package ca.keaneq.domain.model

import ca.keaneq.repository.model.HeldItemEntity

data class HeldItem(
    val name: String,
    val id: String,
    val image: String,
    val upgrades: List<HeldItemUpgrade>,
    val stats: List<HeldItemStat>,
)

fun HeldItemEntity.toDomain() = HeldItem(
    name = name,
    id = id,
    image = image,
    upgrades = upgrades.map { upgrade -> upgrade.toDomain() },
    stats = stats.map { stat -> stat.toDomain() },
)

