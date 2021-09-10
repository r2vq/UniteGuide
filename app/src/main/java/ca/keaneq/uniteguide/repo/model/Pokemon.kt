package ca.keaneq.uniteguide.repo.model

data class Pokemon(
    val id: String,
    val name: String,
    val difficulty: String,
    val style: String,
    val role: String,
    val lane: String,
    val attackType: String,
    val image: String?,
    val evolutions: List<Evolution>,
    val passive: Passive
)