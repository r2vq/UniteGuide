package ca.keaneq.presentation.pokemondetail.model

data class MoveState(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val isExpanded: Boolean = false,
    val cooldown: String? = null,
    val upgrade: Int? = null,
    val moveType: MoveType,
)