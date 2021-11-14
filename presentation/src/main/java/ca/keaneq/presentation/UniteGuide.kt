package ca.keaneq.presentation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ca.keaneq.presentation.main.ActionBar
import ca.keaneq.presentation.main.NavigationDrawer
import ca.keaneq.presentation.main.UniteGuideTheme
import ca.keaneq.presentation.main.navigation.Navigation
import ca.keaneq.presentation.main.navigation.ToolbarState

@Composable
fun UniteGuide(
    appName: String,
    versionName: String
) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val toolbarState = remember { mutableStateOf(ToolbarState.Menu) }
    val scaffoldState = rememberScaffoldState()

    UniteGuideTheme {
        Scaffold(
            topBar = {
                ActionBar(
                    text = appName,
                    drawerState = scaffoldState.drawerState,
                    scope = scope,
                    toolbarState = toolbarState.value,
                    navController = navController,
                )
            },
            drawerContent = {
                NavigationDrawer(
                    navController = navController,
                    drawerState = scaffoldState.drawerState,
                    scope = scope,
                )
            },
            drawerShape = RoundedCornerShape(topEnd = 24.dp),
            content = {
                Navigation(
                    navController = navController,
                    versionName = versionName,
                ) { toolbar ->
                    toolbarState.value = toolbar
                }
            },
            scaffoldState = scaffoldState,
        )
    }
}