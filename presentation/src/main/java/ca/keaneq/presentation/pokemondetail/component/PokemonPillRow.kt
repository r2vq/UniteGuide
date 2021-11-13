package ca.keaneq.presentation.pokemondetail.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ca.keaneq.domain.model.Pokemon
import ca.keaneq.presentation.model.color
import ca.keaneq.presentation.model.onColor
import ca.keaneq.presentation.model.text

@Composable
fun PokemonPillRow(pokemon: Pokemon) {
    PokemonPillRow(
        roleText = pokemon.role.text,
        attackStyleText = pokemon.attackStyle.text,
        color = pokemon.role.color,
        onColor = pokemon.role.onColor,
    )
}

@Composable
fun PokemonPillRow(
    roleText: String,
    attackStyleText: String,
    color: Color,
    onColor: Color,
) {
    Row {
        PillFilled(
            text = roleText,
            color = color,
            onColor = onColor,
        )
        Spacer(modifier = Modifier.width(10.dp))
        PillOutlined(
            text = attackStyleText,
            color = onColor,
            onColor = color,
        )
    }
}