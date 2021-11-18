package ca.keaneq.presentation.main.model

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ca.keaneq.presentation.main.navigation.ToolbarState
import ca.keaneq.presentation.main.navigation.rememberToolbarState
import kotlinx.coroutines.CoroutineScope

class UniteGuideStateHolder(
    val appName: String,
    val versionName: String,
    val navController: NavHostController,
    val scope: CoroutineScope,
    val toolbarState: MutableState<ToolbarState>,
    val scaffoldState: ScaffoldState,
)

@Composable
fun rememberUniteGuideState(
    appName: String = "",
    versionName: String = "",
    navController: NavHostController = rememberNavController(),
    scope: CoroutineScope = rememberCoroutineScope(),
    toolbarState: MutableState<ToolbarState> = rememberToolbarState(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
): UniteGuideStateHolder = UniteGuideStateHolder(
    appName = appName,
    versionName = versionName,
    navController = navController,
    scope = scope,
    toolbarState = toolbarState,
    scaffoldState = scaffoldState,
)