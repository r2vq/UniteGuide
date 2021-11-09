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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.keaneq.presentation.model.MovesetItem
import coil.compose.rememberImagePainter

@Composable
fun Moveset(
    moveItem: MovesetItem,
    onClick: () -> Unit = {}
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
                color = moveItem.onColor(),
            ),
            backgroundColor = moveItem.color(),
            contentColor = contentColorFor(backgroundColor = moveItem.color()),
            shape = RoundedCornerShape(
                topStart = 12.dp,
                topEnd = 12.dp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(moveItem.image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .padding(12.dp)
                )
                Text(
                    style = MaterialTheme.typography.h1,
                    text = moveItem.name,
                    color = moveItem.onColor(),
                )
            }
        }
        Card(
            border = BorderStroke(
                width = 1.dp,
                color = moveItem.onColor(),
            ),
            backgroundColor = moveItem.color(),
            contentColor = contentColorFor(backgroundColor = moveItem.color()),
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(moveItem.upgrade1Image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .padding(12.dp)
                )
                Text(
                    style = MaterialTheme.typography.h2,
                    text = moveItem.upgrade1,
                    color = moveItem.onColor(),
                )
            }
        }
        Card(
            border = BorderStroke(
                width = 1.dp,
                color = moveItem.onColor(),
            ),
            backgroundColor = moveItem.color(),
            contentColor = contentColorFor(backgroundColor = moveItem.color()),
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(moveItem.upgrade2Image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .padding(12.dp)
                )
                Text(
                    style = MaterialTheme.typography.h2,
                    text = moveItem.upgrade2,
                    color = moveItem.onColor(),
                )
            }
        }
    }
}

@Composable
@Preview
fun MovesetPreview() {
    Moveset(
        moveItem = MovesetItem(
            id = 1,
            name = "Seed Bomb",
            description = "Hurls a large seed at the designated area, dealing damage to opposing Pokémon in the area of effect.",
            color = { MaterialTheme.colors.primary },
            onColor = { MaterialTheme.colors.onPrimary },
            image = "",
            upgrade1 = "Sludge Bomb",
            upgrade2 = "Giga Drain",
            upgrade1Image = "",
            upgrade2Image = "",
        ),
    )
}