package ca.keaneq.presentation.settings.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}