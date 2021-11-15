package ca.keaneq.presentation.about

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ca.keaneq.presentation.R
import ca.keaneq.presentation.about.component.AboutItem

@Composable
fun AboutScreen(
    versionName: String = "1.0.0"
) {
    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        item {
            AboutItem(
                title = stringResource(id = R.string.about_version_title),
                subtitle = "v$versionName",
            )
            AboutItem(
                title = stringResource(id = R.string.about_app_title),
                body = stringResource(id = R.string.about_app_body),
            )
            AboutItem(
                title = stringResource(id = R.string.about_privacy_title),
                body = stringResource(id = R.string.about_privacy_body),
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