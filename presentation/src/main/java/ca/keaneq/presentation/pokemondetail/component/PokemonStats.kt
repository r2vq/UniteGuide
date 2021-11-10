package ca.keaneq.presentation.pokemondetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ca.keaneq.domain.model.Pokemon
import ca.keaneq.presentation.model.PokemonItem
import ca.keaneq.presentation.model.text

@Composable
fun PokemonStats(pokemon: Pokemon) {
    PokemonStats(
        attackTypeText = pokemon.attackType.text,
        laneText = pokemon.lane.text,
        difficultyText = pokemon.difficulty.text,
    )
}

@Composable
fun PokemonStats(pokemonItem: PokemonItem) {
    PokemonStats(
        attackTypeText = stringResource(pokemonItem.attackType.text),
        laneText = stringResource(pokemonItem.lane.text),
        difficultyText = stringResource(pokemonItem.difficulty.text),
    )
}

@Composable
fun PokemonStats(
    attackTypeText: String,
    laneText: String,
    difficultyText: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = attackTypeText,
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = "|",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = laneText,
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = "|",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = difficultyText,
            style = MaterialTheme.typography.body1,
        )
    }
}