package ca.keaneq.repository.model

data class PokemonMovesetEntity(
    val basic: PokemonMovesetBasicEntity,
    val upgrades: List<PokemonUpgradeEntity>,
)
