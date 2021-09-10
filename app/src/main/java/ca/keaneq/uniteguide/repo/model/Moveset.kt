package ca.keaneq.uniteguide.repo.model

data class Moveset(
    val basic: BasicMove,
    val upgrades: List<UpgradeMove>
)
