package ca.keaneq.presentation.pokemondetail.component

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.keaneq.domain.model.Move
import ca.keaneq.presentation.model.SingleMoveItem
import coil.compose.rememberImagePainter

@Composable
fun Move(
    move: Move,
    color: Color,
    onColor: Color,
    onClick: () -> Unit = {}
) {
    Move(
        image = move.image,
        color = color,
        onColor = onColor,
        text = move.name,
        onClick = onClick,
    )
}

@Composable
fun Move(
    moveItem: SingleMoveItem,
    onClick: () -> Unit = {}
) {
    Move(
        image = moveItem.image,
        color = moveItem.color(),
        onColor = moveItem.onColor(),
        text = moveItem.name,
        onClick = onClick
    )
}

@Composable
fun Move(
    image: String,
    color: Color,
    onColor: Color,
    text: String,
    onClick: () -> Unit = {}
) {
    Card(
        border = BorderStroke(
            width = 1.dp,
            color = onColor
        ),
        backgroundColor = color,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp,
            )
            .clickable { onClick() }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(image),
                contentDescription = null,
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
                    .padding(12.dp)
            )
            Text(
                style = MaterialTheme.typography.h1,
                text = text,
                color = onColor,
            )
        }
    }
}

@Composable
@Preview
fun PreviewMove() {
    Move(
        image = "",
        color = Color.Blue,
        onColor = Color.White,
        text = "Brave Bird",
    ) {

    }
}