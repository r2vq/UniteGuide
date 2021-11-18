package ca.keaneq.presentation.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ca.keaneq.presentation.main.navigation.ToolbarState
import ca.keaneq.presentation.main.navigation.rememberToolbarState

@Composable
fun ActionBar(
    text: String = "",
    toolbarState: ToolbarState = rememberToolbarState(ToolbarState.Menu).value,
    onOpenDrawer: () -> Unit = {},
    onCloseDrawer: () -> Unit = {},
    onPopBackStack: () -> Unit = {},
) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = when (toolbarState) {
                    ToolbarState.Up -> onPopBackStack
                    ToolbarState.Menu -> onOpenDrawer
                    ToolbarState.Close -> onCloseDrawer
                }
            ) {
                Icon(
                    imageVector = toolbarState.icon,
                    contentDescription = stringResource(id = toolbarState.contentDescription),
                )
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        title = { Text(text = text) },
    )
}