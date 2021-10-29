package ca.keaneq.uniteguide.domain.model

import androidx.compose.ui.graphics.Color

data class PokemonItem(
    val name: String,
    val imageUrl: String,
    val color: Color,
    val onColor: Color,
)
