package ca.keaneq.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ca.keaneq.presentation.R
import ca.keaneq.presentation.main.navigation.Screen

@Composable
fun NavigationDrawer(
    onNavigateAndCloseScaffold: (Screen) -> Unit = { },
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
                        onNavigateAndCloseScaffold = onNavigateAndCloseScaffold,
                    )
                }
                item {
                    DrawerItem.HELD_ITEM.ToNavigationDrawerItem(
                        onNavigateAndCloseScaffold = onNavigateAndCloseScaffold,
                    )
                }
                item {
                    DrawerItem.ABOUT.ToNavigationDrawerItem(
                        onNavigateAndCloseScaffold = onNavigateAndCloseScaffold,
                    )
                }
                item {
                    DrawerItem.SETTING.ToNavigationDrawerItem(
                        onNavigateAndCloseScaffold = onNavigateAndCloseScaffold,
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