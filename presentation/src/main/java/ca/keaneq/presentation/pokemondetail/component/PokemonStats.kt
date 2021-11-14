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
import ca.keaneq.domain.model.AttackType
import ca.keaneq.domain.model.Difficulty
import ca.keaneq.domain.model.Lane
import ca.keaneq.domain.model.Pokemon
import ca.keaneq.presentation.R

@Composable
fun PokemonStats(pokemon: Pokemon) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = pokemon.attackType.text,
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = "|",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = pokemon.lane.text,
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = "|",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = pokemon.difficulty.text,
            style = MaterialTheme.typography.body1,
        )
    }
}

private val AttackType.text
    @Composable
    get() = stringResource(
        when (this) {
            AttackType.PHYSICAL -> R.string.attack_type_physical
            AttackType.SPECIAL -> R.string.attack_type_special
            AttackType.UNSPECIFIED -> R.string.attack_style_unspecified
        }
    )

private val Difficulty.text
    @Composable
    get() = stringResource(
        when (this) {
            Difficulty.NOVICE -> R.string.difficulty_novice
            Difficulty.INTERMEDIATE -> R.string.difficulty_intermediate
            Difficulty.EXPERT -> R.string.difficulty_expert
            Difficulty.UNSPECIFIED -> R.string.difficulty_unspecified
        }
    )

private val Lane.text
    @Composable
    get() = stringResource(
        when (this) {
            Lane.TOP -> R.string.lane_top
            Lane.CENTER -> R.string.lane_center
            Lane.BOTTOM -> R.string.lane_bottom
            Lane.UNSPECIFIED -> R.string.lane_unspecified
        }
    )