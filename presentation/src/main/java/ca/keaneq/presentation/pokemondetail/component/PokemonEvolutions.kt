package ca.keaneq.presentation.pokemondetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ca.keaneq.domain.model.Pokemon
import ca.keaneq.presentation.R
import ca.keaneq.presentation.model.PokemonItem
import coil.compose.rememberImagePainter

@Composable
fun PokemonEvolutions(pokemon: Pokemon) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        pokemon.evolutions.forEachIndexed { i, evolutionItem ->
            Evolution(
                name = evolutionItem.name,
                showLevel = i > 0,
                imageUrl = evolutionItem.image,
                evolutionLevel = evolutionItem.level,
            )
        }
    }
}

@Composable
fun PokemonEvolutions(pokemon: PokemonItem) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        pokemon.evolutions.forEachIndexed { i, evolutionItem ->
            Evolution(
                name = evolutionItem.name,
                showLevel = i > 0,
                imageUrl = evolutionItem.image,
                evolutionLevel = evolutionItem.level,
            )
        }
    }
}

@Composable
fun Evolution(
    name: String,
    showLevel: Boolean,
    imageUrl: String,
    evolutionLevel: Int
) {
    if (showLevel) {
        Text(
            style = MaterialTheme.typography.body1,
            text = stringResource(id = R.string.evolves_at, evolutionLevel),
            modifier = Modifier.padding(8.dp)
        )
    }
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = name,
        modifier = Modifier
            .height(75.dp)
            .width(75.dp)
    )
}