package ca.keaneq.repository.model

data class PokemonEntity(
    val id: String,
    val name: String,
    val difficulty: String,
    val style: String,
    val role: String,
    val lane: String,
    val attackType: String,
    val stars: PokemonStarsEntity,
    val image: String?,
    val evolutions: List<PokemonEvolutionEntity>,
    val moveset: List<PokemonMovesetEntity>,
    val passive: PokemonMoveEntity,
    val basic: PokemonMoveEntity,
    val unite: PokemonMoveEntity
)