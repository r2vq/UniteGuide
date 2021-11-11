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
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.*
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
) {
    var isExpanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp,
            )
            .animateContentSize()
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
                .clickable { isExpanded = !isExpanded }
                .animateContentSize()
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
                        painter = rememberImagePainter(moveset.image),
                        contentDescription = null,
                        modifier = Modifier
                            .height(48.dp)
                            .width(48.dp)
                            .padding(end = 12.dp)
                    )
                    Text(
                        style = MaterialTheme.typography.h1,
                        text = moveset.name,
                        color = onColor,
                    )
                }
                if (isExpanded) {
                    Text(
                        style = MaterialTheme.typography.body1,
                        text = moveset.description,
                        color = onColor,
                    )
                }
            }
        }
        moveset.upgrades.forEachIndexed { i, upgrade ->
            MovesetUpgrade(
                isLastMove = i + 1 == moveset.upgrades.size,
                upgrade = upgrade,
                color = color,
                onColor = onColor
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
) {
    var isExpanded by remember { mutableStateOf(false) }
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
            .clickable { isExpanded = !isExpanded }
            .animateContentSize()
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
                    painter = rememberImagePainter(upgrade.image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .padding(end = 12.dp)
                )
                Text(
                    style = MaterialTheme.typography.h1,
                    text = upgrade.name,
                    color = onColor,
                )
            }
            if (isExpanded) {
                Text(
                    style = MaterialTheme.typography.body1,
                    text = upgrade.description,
                    color = onColor,
                )
            }
        }
    }
}