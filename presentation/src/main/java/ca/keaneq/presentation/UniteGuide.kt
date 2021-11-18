package ca.keaneq.presentation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.presentation.main.ActionBar
import ca.keaneq.presentation.main.NavigationDrawer
import ca.keaneq.presentation.main.UniteGuideTheme
import ca.keaneq.presentation.main.model.UniteGuideStateHolder
import ca.keaneq.presentation.main.model.rememberUniteGuideState
import ca.keaneq.presentation.main.navigation.UniteGuideContent
import ca.keaneq.presentation.main.viewmodel.ThemeViewModel
import kotlinx.coroutines.launch

@Composable
fun UniteGuide(
    appName: String = "",
    versionName: String = "",
    state: UniteGuideStateHolder = rememberUniteGuideState(
        appName = appName,
        versionName = versionName
    ),
    viewModel: ThemeViewModel = hiltViewModel(),
) {
    UniteGuideTheme(
        theme = viewModel.theme.collectAsState().value
    ) {
        Scaffold(
            topBar = {
                ActionBar(
                    text = state.appName,
                    toolbarState = state.toolbarState.value,
                    onOpenDrawer = { state.scope.launch { state.scaffoldState.drawerState.open() } },
                    onCloseDrawer = { state.scope.launch { state.scaffoldState.drawerState.close() } },
                    onPopBackStack = { state.navController.popBackStack() },
                )
            },
            drawerContent = {
                NavigationDrawer { screen ->
                    state.navController.navigate(screen.route) {
                        launchSingleTop = true
                        popUpTo(screen.route)
                    }
                    state.scope.launch { state.scaffoldState.drawerState.close() }
                }
            },
            drawerShape = RoundedCornerShape(topEnd = 24.dp),
            content = {
                UniteGuideContent(
                    navController = state.navController,
                    versionName = state.versionName,
                    onChangeToolbarState = { toolbar -> state.toolbarState.value = toolbar },
                    onNavigate = { route -> state.navController.navigate(route) },
                )
            },
            scaffoldState = state.scaffoldState,
        )
    }
}