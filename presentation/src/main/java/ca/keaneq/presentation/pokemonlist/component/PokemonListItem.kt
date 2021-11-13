package ca.keaneq.presentation.pokemonlist.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ca.keaneq.domain.model.Pokemon
import ca.keaneq.presentation.R
import ca.keaneq.presentation.model.color
import coil.compose.rememberImagePainter

@Composable
fun PokemonListItem(
    pokemon: Pokemon,
    isFirstItem: Boolean = false,
    onItemClick: () -> Unit = {},
) {
    Card(
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .padding(
                start = 8.dp,
                top = if (isFirstItem) 8.dp else 0.dp,
                end = 8.dp,
                bottom = 8.dp,
            )
            .fillMaxWidth()
            .clickable { onItemClick() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier.background(pokemon.role.color)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_pokeball),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(
                            width = 150.dp,
                            height = 100.dp,
                        )
                        .alpha(0.2f)
                        .fillMaxWidth(),
                )
                Image(
                    painter = rememberImagePainter(pokemon.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(
                            start = 16.dp,
                            top = 8.dp,
                            bottom = 8.dp
                        )
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = pokemon.name,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .padding(16.dp),
                )
            }
        }
    }
}