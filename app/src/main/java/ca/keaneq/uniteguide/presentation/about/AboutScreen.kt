package ca.keaneq.uniteguide.presentation.about

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ca.keaneq.uniteguide.R

@Composable
fun AboutScreen() {
    Text(stringResource(id = R.string.title_about))
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    AboutScreen()
}