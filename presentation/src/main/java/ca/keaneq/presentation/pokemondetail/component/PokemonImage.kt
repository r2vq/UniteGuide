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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.keaneq.domain.model.Pokemon
import ca.keaneq.presentation.model.*
import coil.compose.rememberImagePainter

@Composable
fun PokemonImage(
    pokemon: Pokemon
) {
    PokemonImage(
        name = pokemon.name,
        imageUrl = pokemon.imageUrl,
        color = pokemon.role.color,
        onColor = pokemon.role.onColor,
    )
}

@Composable
fun PokemonImage(
    pokemon: PokemonItem
) {
    PokemonImage(
        name = pokemon.name,
        imageUrl = pokemon.imageUrl,
        color = pokemon.role.color(),
        onColor = pokemon.role.onColor(),
    )
}

@Composable
fun PokemonImage(
    name: String,
    imageUrl: String?,
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
                text = name,
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
            rememberImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
fun PreviewPokemonImageSpeedster() {
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
        moves = emptyList(),
    )
    PokemonImage(pokemon)
}