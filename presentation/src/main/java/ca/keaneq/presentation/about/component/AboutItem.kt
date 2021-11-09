package ca.keaneq.presentation.about.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.keaneq.presentation.R

@Composable
fun AboutItem(
    title: String? = null,
    subtitle: String? = null,
    body: String? = null,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 8.dp,
            ),
        shape = MaterialTheme.shapes.medium,
        elevation = 10.dp,
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier.padding(4.dp),
                    )
                }
                subtitle?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(4.dp),
                    )
                }
            }
            body?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(4.dp),
                )
            }
        }
    }
}

@Preview(backgroundColor = 0xffdfdfdf, showBackground = true)
@Composable
fun AboutItemPreviewTitleSubtitle() {
    AboutItem(
        title = stringResource(id = R.string.about_version_title),
        subtitle = "v1.2.3",
    )
}

@Preview(backgroundColor = 0xffdfdfdf, showBackground = true)
@Composable
fun AboutItemPreviewTitleBody() {
    AboutItem(
        title = stringResource(id = R.string.about_disclaimer_title),
        subtitle = stringResource(id = R.string.about_disclaimer_body),
    )
}