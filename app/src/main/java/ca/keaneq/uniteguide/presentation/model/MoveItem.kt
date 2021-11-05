package ca.keaneq.uniteguide.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ca.keaneq.domain.model.Move

data class MoveItem(
    val id: Int,
    val name: String,
    val description: String,
    val color: @Composable () -> Color,
    val onColor: @Composable () -> Color,
    val image: String,
)

fun Move.toMoveItem(
    id: Int,
    color: @Composable () -> Color,
    onColor: @Composable () -> Color,
): MoveItem = MoveItem(
    id = id,
    name = name,
    description = description,
    image = image,
    color = color,
    onColor = onColor,
)
