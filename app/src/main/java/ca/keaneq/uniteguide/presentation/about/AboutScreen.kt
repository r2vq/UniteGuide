package ca.keaneq.uniteguide.presentation.about

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ca.keaneq.uniteguide.BuildConfig
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.presentation.about.component.AboutItem

@Composable
fun AboutScreen() {
    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        item {
            AboutItem(
                title = stringResource(id = R.string.about_version_title),
                subtitle = "v${BuildConfig.VERSION_NAME}",
            )
            AboutItem(
                title = stringResource(id = R.string.about_disclaimer_title),
                body = stringResource(id = R.string.about_disclaimer_body),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    AboutScreen()
}