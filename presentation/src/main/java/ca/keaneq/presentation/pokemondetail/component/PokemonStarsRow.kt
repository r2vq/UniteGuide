package ca.keaneq.presentation.pokemondetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun StarsRow(
    text: String,
    score: Float,
    color: Color,
    onColor: Color,
    isTop: Boolean = false,
    isBottom: Boolean = false,
) {
    Row(
        modifier = Modifier
            .padding(
                start = 4.dp,
                top = if (isTop) 8.dp else 4.dp,
                end = 4.dp,
                bottom = if (isBottom) 16.dp else 4.dp,
            )
    ) {
        Text(
            text = text,
            maxLines = 1,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .weight(0.2f)
                .padding(start = 8.dp)
        )
        Box(
            modifier = Modifier
                .height(20.dp)
                .weight(0.8f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        start = 8.dp,
                        end = 8.dp
                    )
                    .fillMaxWidth()
            ) {
                for (i in 1..5) {
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxHeight()
                            .clip(
                                RoundedCornerShape(
                                    topStart = if (i == 1) 20.dp else 0.dp,
                                    bottomStart = if (i == 1) 20.dp else 0.dp,
                                )
                            )
                            .background(color)
                    )
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxHeight()
                            .clip(
                                RoundedCornerShape(
                                    topEnd = if (i == 5) 20.dp else 0.dp,
                                    bottomEnd = if (i == 5) 20.dp else 0.dp,
                                )
                            )
                            .background(color)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 2.dp,
                        bottom = 2.dp,
                    )
                    .fillMaxWidth()
            ) {
                for (i in 0 until 5) {
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxHeight()
                            .padding(start = 2.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = if (i == 0) 20.dp else 0.dp,
                                    bottomStart = if (i == 0) 20.dp else 0.dp,
                                )
                            )
                            .background(
                                if (score > i) {
                                    onColor
                                } else {
                                    color
                                }
                            )
                    )
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxHeight()
                            .padding(end = 2.dp)
                            .clip(
                                RoundedCornerShape(
                                    topEnd = if (i == 4) 20.dp else 0.dp,
                                    bottomEnd = if (i == 4) 20.dp else 0.dp,
                                )
                            )
                            .background(
                                if (score > i + 0.5) {
                                    onColor
                                } else {
                                    color
                                }
                            )
                    )
                }
            }
        }
    }
}