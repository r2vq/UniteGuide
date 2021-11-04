package ca.keaneq.uniteguide.presentation.pokemonlist.component

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.presentation.model.*
import coil.compose.rememberImagePainter

@Composable
fun PokemonListItem(
    pokemon: PokemonItem,
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
                modifier = Modifier.background(pokemon.role.color())
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

@Preview
@Composable
fun PokemonListItemVenusaurPreview() {
    val pokemon = PokemonItem(
        id = "001",
        name = "Venusaur",
        imageUrl = "https://raw.githubusercontent.com/r2vq/r2vq.github.io/master/unite/img/Pokemon_Venusaur.png",
        role = RoleItem.ATTACKER,
        attackType = AttackTypeItem.SPECIAL,
        lane = LaneItem.TOP,
        difficulty = DifficultyItem.INTERMEDIATE,
        attackStyle = AttackStyleItem.RANGED,
        evolutions = emptyList(),
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
        role = RoleItem.SPEEDSTER,
        attackType = AttackTypeItem.PHYSICAL,
        lane = LaneItem.TOP,
        difficulty = DifficultyItem.NOVICE,
        attackStyle = AttackStyleItem.MELEE,
        evolutions = emptyList(),
    )
    PokemonListItem(pokemon = pokemon)
}