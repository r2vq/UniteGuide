package ca.keaneq.presentation.helditemdetail.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

data class HeldItemDetailUpgrade(
    val level: Int,
    val description: String,
    val image: String,
) : HeldItemDetailComponent() {
    @Composable
    override fun Draw() {
        var isExpanded by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .animateContentSize()
                .clickable {
                    isExpanded = !isExpanded
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    if (image.isNotEmpty()) {
                        Image(
                            painter = rememberImagePainter(image),
                            contentDescription = null,
                            modifier = Modifier
                                .width(48.dp)
                                .heightIn(48.dp)
                        )
                    }
                    Text(
                        text = "Upgrade at Level: $level",
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                if (isExpanded) {
                    Text(
                        text = description,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}