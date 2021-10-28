package ca.keaneq.uniteguide.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun NavigationDrawer() {
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
                item { DrawerItem.POKEMON.ToNavigationDrawerItem() }
                item { DrawerItem.ABOUT.ToNavigationDrawerItem() }
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