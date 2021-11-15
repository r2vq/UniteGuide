package ca.keaneq.presentation.helditemlist.component

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
import androidx.compose.ui.unit.dp
import ca.keaneq.domain.model.HeldItem
import coil.compose.rememberImagePainter

@Composable
fun HeldListItem(
    heldItem: HeldItem,
    onClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 4.dp
            )
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                rememberImagePainter(heldItem.image),
                contentDescription = null,
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
            )
            Text(
                text = heldItem.name,
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp
                    )
            )
        }
    }
}