package ca.keaneq.uniteguide.presentation.pokemonlist.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.domain.model.PokemonItem
import coil.compose.rememberImagePainter

@Composable
fun PokemonListItem(
    pokemon: PokemonItem,
    onItemClick: () -> Unit = {},
) {
    Card(
        backgroundColor = pokemon.color,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable { onItemClick() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Box {
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
                    color = pokemon.onColor,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier
                        .padding(16.dp),
                )
            }
        }
    }
}

private val PokemonItem.color: Color
    get() = when (role) {
        "allrounder" -> Color(0xff4527a0)
        "attacker" -> Color(0xfff06f2a)
        "defender" -> Color(0xff689f38)
        "speedster" -> Color(0xff0277bd)
        "supporter" -> Color(0xffffd54f)
        else -> Color.Black
    }

private val PokemonItem.onColor: Color
    get() = when (role) {
        "allrounder" -> Color.White
        "attacker" -> Color.Black
        "defender" -> Color.Black
        "speedster" -> Color.White
        "supporter" -> Color.Black
        else -> Color.White
    }

@Preview
@Composable
fun PokemonListItemVenusaurPreview() {
    val pokemon = PokemonItem(
        id = "001",
        name = "Venusaur",
        imageUrl = "https://raw.githubusercontent.com/r2vq/r2vq.github.io/master/unite/img/Pokemon_Venusaur.png",
        role = "attacker",
    )
    PokemonListItem(pokemon = pokemon)
}

@Preview
@Composable
fun PokemonListItemTalonflamePreview() {
    val pokemon = PokemonItem(
        id = "002",
        name = "Talonflame",
        imageUrl = "https://raw.githubusercontent.com/r2vq/r2vq.github.io/master/unite/img/Pokemon_Talonflame.png",
        role = "speedster",
    )
    PokemonListItem(pokemon = pokemon)
}