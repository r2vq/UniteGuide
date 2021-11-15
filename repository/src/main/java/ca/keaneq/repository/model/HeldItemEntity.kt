package ca.keaneq.repository.model

data class HeldItemEntity(
    val name: String,
    val image: String,
    val upgrades: List<HeldItemUpgradeEntity>,
    val stats: List<HeldItemStatEntity>,
)
