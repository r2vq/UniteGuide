package ca.keaneq.presentation.pokemondetail.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ca.keaneq.domain.model.Moveset
import ca.keaneq.domain.model.Upgrade
import coil.compose.rememberImagePainter

@Composable
fun Moveset(
    moveset: Moveset,
    color: Color,
    onColor: Color,
    onOpenBottomSheet: (title: String, body: String, image: String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp,
            )
    ) {
        Card(
            border = BorderStroke(
                width = 1.dp,
                color = onColor,
            ),
            backgroundColor = color,
            contentColor = contentColorFor(backgroundColor = color),
            shape = RoundedCornerShape(
                topStart = 12.dp,
                topEnd = 12.dp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onOpenBottomSheet(
                        moveset.name, moveset.description, moveset.image
                    )
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(moveset.image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .padding(12.dp)
                )
                Text(
                    style = MaterialTheme.typography.h1,
                    text = moveset.name,
                    color = onColor,
                )
            }
        }
        moveset.upgrades.forEachIndexed { i, upgrade ->
            MovesetUpgrade(
                isLastMove = i + 1 == moveset.upgrades.size,
                upgrade = upgrade,
                color = color,
                onColor = onColor,
                onOpenBottomSheet = onOpenBottomSheet
            )
        }
    }
}

@Composable
private fun MovesetUpgrade(
    isLastMove: Boolean,
    upgrade: Upgrade,
    color: Color,
    onColor: Color,
    onOpenBottomSheet: (title: String, body: String, image: String) -> Unit,
) {
    Card(
        border = BorderStroke(
            width = 1.dp,
            color = onColor,
        ),
        backgroundColor = color,
        contentColor = contentColorFor(backgroundColor = color),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = if (isLastMove) 12.dp else 0.dp,
            bottomEnd = if (isLastMove) 12.dp else 0.dp,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onOpenBottomSheet(
                    upgrade.name,
                    upgrade.description,
                    upgrade.image,
                )
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(upgrade.image),
                contentDescription = null,
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
                    .padding(12.dp)
            )
            Text(
                style = MaterialTheme.typography.h2,
                text = upgrade.name,
                color = onColor,
            )
        }
    }
}