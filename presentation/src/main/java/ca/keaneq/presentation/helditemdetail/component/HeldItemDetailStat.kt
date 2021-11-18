package ca.keaneq.presentation.helditemdetail.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class HeldItemDetailStat(
    val name: String,
    val details: List<HeldItemStatDetail>,
) : HeldItemDetailComponent() {
    @Composable
    override fun Draw() {
        var isExpanded by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .clickable { isExpanded = !isExpanded }
                .animateContentSize()
        ) {
            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.padding(16.dp)
                )
                if (isExpanded) {
                    details.forEach { detail -> detail.Draw() }
                }
            }
        }
    }
}

data class HeldItemStatDetail(
    val level: String,
    val description: String,
) : HeldItemDetailComponent() {
    @Composable
    override fun Draw() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = level,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}