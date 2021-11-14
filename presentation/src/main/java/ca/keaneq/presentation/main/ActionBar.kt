package ca.keaneq.presentation.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ca.keaneq.presentation.main.navigation.ToolbarState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ActionBar(
    text: String = "",
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    scope: CoroutineScope = rememberCoroutineScope(),
    toolbarState: ToolbarState = ToolbarState.Menu,
    navController: NavController = rememberNavController(),
) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = when (toolbarState) {
                    ToolbarState.Up -> {
                        { navController.popBackStack() }
                    }
                    ToolbarState.Menu -> {
                        { scope.launch { drawerState.open() } }
                    }
                    ToolbarState.Close -> {
                        { scope.launch { drawerState.close() } }
                    }
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

@Preview
@Composable
fun ActionBarPreviewMenu() {
    ActionBar(
        text = stringResource(id = ToolbarState.Menu.contentDescription),
        toolbarState = ToolbarState.Menu,
    )
}

@Preview
@Composable
fun ActionBarPreviewUp() {
    ActionBar(
        text = stringResource(id = ToolbarState.Up.contentDescription),
        toolbarState = ToolbarState.Up,
    )
}

@Preview
@Composable
fun ActionBarPreviewClose() {
    ActionBar(
        text = stringResource(id = ToolbarState.Close.contentDescription),
        toolbarState = ToolbarState.Close,
    )
}