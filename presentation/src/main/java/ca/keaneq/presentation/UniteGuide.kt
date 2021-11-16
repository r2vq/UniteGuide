package ca.keaneq.presentation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import ca.keaneq.presentation.main.ActionBar
import ca.keaneq.presentation.main.NavigationDrawer
import ca.keaneq.presentation.main.UniteGuideTheme
import ca.keaneq.presentation.main.navigation.Navigation
import ca.keaneq.presentation.main.navigation.ToolbarState
import ca.keaneq.presentation.main.viewmodel.ThemeViewModel

@Composable
fun UniteGuide(
    appName: String,
    versionName: String,
    viewModel: ThemeViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val toolbarState = remember { mutableStateOf(ToolbarState.Menu) }
    val scaffoldState = rememberScaffoldState()

    UniteGuideTheme(
        theme = viewModel.theme.collectAsState().value
    ) {
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