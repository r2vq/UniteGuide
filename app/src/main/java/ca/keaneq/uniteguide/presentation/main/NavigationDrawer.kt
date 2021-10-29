package ca.keaneq.uniteguide.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavigationDrawer(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    scope: CoroutineScope = rememberCoroutineScope(),
) {
    Surface(
        color = MaterialTheme.colors.primary
    ) {
        LazyColumn(
            content = {
                item {
                    Row {
                        Image(
                            painter = rememberImagePainter("https://raw.githubusercontent.com/r2vq/r2vq.github.io/master/unite/img/Pokemon_Talonflame.png"),
                            contentDescription = null,
                            modifier = Modifier.size(128.dp)
                        )
                        Image(
                            painter = rememberImagePainter("https://raw.githubusercontent.com/r2vq/r2vq.github.io/master/unite/img/Pokemon_Pikachu.png"),
                            contentDescription = null,
                            modifier = Modifier.size(128.dp)
                        )
                    }
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