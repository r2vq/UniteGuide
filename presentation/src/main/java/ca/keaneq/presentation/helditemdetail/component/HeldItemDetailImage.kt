package ca.keaneq.presentation.helditemdetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

data class HeldItemDetailImage(
    val url: String
) : HeldItemDetailComponent() {
    @Composable
    override fun Draw() {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .heightIn(max = 200.dp)
        )
    }
}
