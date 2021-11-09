package ca.keaneq.repository.model

data class PokemonMovesetBasicEntity(
    val name: String,
    val cooldown: String,
    val description: String,
    val image: String,
    val upgrade: Int,
)

