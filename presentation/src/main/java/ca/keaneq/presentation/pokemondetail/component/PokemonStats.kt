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
import ca.keaneq.presentation.model.PokemonItem

@Composable
fun PokemonStats(
    pokemonItem: PokemonItem
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(pokemonItem.attackType.text),
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = "|",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(pokemonItem.lane.text),
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = "|",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(pokemonItem.difficulty.text),
            style = MaterialTheme.typography.body1,
        )
    }
}