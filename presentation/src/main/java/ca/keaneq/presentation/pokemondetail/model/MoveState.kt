package ca.keaneq.presentation.pokemondetail.model

data class MoveState(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val isExpanded: Boolean,
    val moveType: MoveType,
)