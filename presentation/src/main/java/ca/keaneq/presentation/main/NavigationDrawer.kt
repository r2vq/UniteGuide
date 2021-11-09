package ca.keaneq.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ca.keaneq.presentation.R
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavigationDrawer(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    scope: CoroutineScope = rememberCoroutineScope(),
) {
    Surface(
        color = MaterialTheme.colors.surface
    ) {
        LazyColumn(
            content = {
                item {
                    Image(
                        painter = painterResource(R.drawable.ic_nav_title),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item {
                    DrawerItem.POKEMON.ToNavigationDrawerItem(
                        navController = navController,
                        drawerState = drawerState,
                        scope = scope
                    )
                }
                item {
                    DrawerItem.ABOUT.ToNavigationDrawerItem(
                        navController = navController,
                        drawerState = drawerState,
                        scope = scope
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun NavigationDrawerPreview() {
    NavigationDrawer()
}