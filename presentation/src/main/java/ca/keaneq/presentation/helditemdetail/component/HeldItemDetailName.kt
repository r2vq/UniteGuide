package ca.keaneq.presentation.helditemdetail.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class HeldItemDetailName(
    val name: String
) : HeldItemDetailComponent() {
    @Composable
    override fun Draw() {
        Text(
            text = name,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun PreviewHeldItemDetailName() {
    HeldItemDetailName("Buddy Barrier").Draw()
}