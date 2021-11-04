package ca.keaneq.uniteguide.presentation.pokemondetail.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ca.keaneq.uniteguide.presentation.model.PokemonItem

@Composable
fun PokemonPillRow(pokemon: PokemonItem) {
    Row {
        PillFilled(
            text = stringResource(pokemon.role.text),
            color = pokemon.role.color(),
            onColor = pokemon.role.onColor(),
        )
        Spacer(modifier = Modifier.width(10.dp))
        PillOutlined(
            text = stringResource(pokemon.attackStyle.text),
            color = pokemon.role.onColor(),
            onColor = pokemon.role.color(),
        )
    }
}