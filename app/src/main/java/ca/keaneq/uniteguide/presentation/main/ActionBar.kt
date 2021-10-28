package ca.keaneq.uniteguide.presentation.main

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ca.keaneq.uniteguide.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ActionBar(
    text: String = "",
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    scope: CoroutineScope = rememberCoroutineScope(),
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = stringResource(id = R.string.descriptor_menu_button)
                )
            }
        },
        title = { Text(text = text) }
    )
}

@Preview
@Composable
fun ActionBarPreview() {
    ActionBar(
        "Hello world!"
    )
}