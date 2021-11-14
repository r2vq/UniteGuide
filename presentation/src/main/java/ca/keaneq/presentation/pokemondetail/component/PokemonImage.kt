package ca.keaneq.presentation.pokemondetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ca.keaneq.domain.model.Pokemon
import coil.compose.rememberImagePainter

@Composable
fun PokemonImage(
    pokemon: Pokemon,
    color: Color,
    onColor: Color,
) {
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.h1,
                color = onColor,
                modifier = Modifier
                    .background(color)
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Box(
                modifier = Modifier
                    .background(color)
                    .fillMaxWidth()
                    .height(175.dp)
            )
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxWidth()
                    .height(75.dp)
            )
        }
        Image(
            rememberImagePainter(pokemon.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        )
    }
}