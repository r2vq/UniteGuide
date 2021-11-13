package ca.keaneq.presentation.pokemondetail.model

data class PokemonDetailState(
    val isLoading: Boolean = false,
    val pokemon: PokemonState? = null,
    val error: String? = null
)