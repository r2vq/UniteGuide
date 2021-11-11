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
import androidx.compose.ui.unit.dp
import ca.keaneq.domain.model.Move
import coil.compose.rememberImagePainter

@Composable
fun Move(
    move: Move,
    color: Color,
    onColor: Color,
    isExpanded: Boolean,
    onClick: () -> Unit
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
            .animateContentSize()
            .clickable { onClick() }
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
                    painter = rememberImagePainter(move.image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .padding(end = 12.dp)
                )
                Text(
                    style = MaterialTheme.typography.h1,
                    text = move.name,
                    color = onColor,
                )
            }
            if (isExpanded) {
                Text(
                    style = MaterialTheme.typography.body1,
                    text = move.description,
                    color = onColor,
                )
            }
        }
    }
}