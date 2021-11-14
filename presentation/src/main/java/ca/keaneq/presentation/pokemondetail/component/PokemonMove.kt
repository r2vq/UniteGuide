package ca.keaneq.presentation.pokemondetail.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ca.keaneq.presentation.R
import ca.keaneq.presentation.pokemondetail.model.MoveState
import ca.keaneq.presentation.pokemondetail.model.MoveType
import coil.compose.rememberImagePainter

@Composable
fun Move(
    moveState: MoveState,
    color: Color,
    onColor: Color,
    onClick: (Int) -> Unit
) {
    Card(
        border = BorderStroke(
            width = 1.dp,
            color = onColor
        ),
        backgroundColor = color,
        shape = moveState.moveType.toShape,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = moveState.moveType.toTopPadding,
                bottom = moveState.moveType.toBottomPadding,
                start = 8.dp,
                end = 8.dp,
            )
            .animateContentSize()
            .clickable { onClick(moveState.id) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(moveState.image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .padding(end = 12.dp)
                )
                Text(
                    style = MaterialTheme.typography.h1,
                    text = moveState.name,
                    color = onColor,
                )
            }
            if (moveState.isExpanded) {
                moveState.cooldown?.let { cooldown ->
                    Text(
                        style = MaterialTheme.typography.body2,
                        text = stringResource(R.string.move_cooldown, cooldown),
                        color = onColor,
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                    )
                }
                Text(
                    style = MaterialTheme.typography.body2,
                    text = moveState.description,
                    color = onColor,
                )
                moveState.upgrade?.let { upgrade ->
                    Text(
                        style = MaterialTheme.typography.body2,
                        text = stringResource(R.string.move_upgrade, upgrade),
                        color = onColor,
                        modifier = Modifier
                            .padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

private val MoveType.toShape
    @Composable
    get() = when (this) {
        MoveType.SINGLE -> RoundedCornerShape(12.dp)
        MoveType.BASIC_ABILITY -> RoundedCornerShape(
            topStart = 12.dp,
            topEnd = 12.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        )
        MoveType.UPGRADE_ABILITY -> RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        )
        MoveType.UPGRADE_ABILITY_END -> RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 12.dp,
            bottomEnd = 12.dp
        )
    }

private val MoveType.toTopPadding
    get() = when (this) {
        MoveType.SINGLE -> 4.dp
        MoveType.BASIC_ABILITY -> 4.dp
        MoveType.UPGRADE_ABILITY -> 0.dp
        MoveType.UPGRADE_ABILITY_END -> 0.dp
    }

private val MoveType.toBottomPadding
    get() = when (this) {
        MoveType.SINGLE -> 4.dp
        MoveType.BASIC_ABILITY -> 0.dp
        MoveType.UPGRADE_ABILITY -> 0.dp
        MoveType.UPGRADE_ABILITY_END -> 4.dp
    }
