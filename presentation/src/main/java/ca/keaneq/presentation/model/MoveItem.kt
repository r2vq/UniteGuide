package ca.keaneq.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ca.keaneq.domain.model.Move
import ca.keaneq.domain.model.Moveset

sealed class MoveItem {
    abstract val id: Int
    abstract val image: String
    abstract val name: String
    abstract val description: String
}

data class SingleMoveItem(
    override val id: Int,
    override val name: String,
    override val description: String,
    val color: @Composable () -> Color,
    val onColor: @Composable () -> Color,
    override val image: String,
) : MoveItem()

data class MovesetItem(
    override val id: Int,
    override val name: String,
    override val description: String,
    val color: @Composable () -> Color,
    val onColor: @Composable () -> Color,
    override val image: String,
    val upgrade1: String,
    val upgrade2: String,
    val upgrade1Image: String,
    val upgrade2Image: String,
) : MoveItem()

fun Move.toMoveItem(
    id: Int,
    color: @Composable () -> Color,
    onColor: @Composable () -> Color,
): SingleMoveItem = SingleMoveItem(
    id = id,
    name = name,
    description = description,
    image = image,
    color = color,
    onColor = onColor,
)

fun Moveset.toMoveItem(
    id: Int,
    color: @Composable () -> Color,
    onColor: @Composable () -> Color,
): MovesetItem = MovesetItem(
    id = id,
    name = name,
    description = description,
    color = color,
    onColor = onColor,
    image = image,
    upgrade1 = upgrades.getOrNull(0)?.name ?: "",
    upgrade2 = upgrades.getOrNull(1)?.name ?: "",
    upgrade1Image = upgrades.getOrNull(0)?.image ?: "",
    upgrade2Image = upgrades.getOrNull(1)?.image ?: "",
)
