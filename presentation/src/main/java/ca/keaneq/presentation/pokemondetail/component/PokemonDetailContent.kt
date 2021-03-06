package ca.keaneq.presentation.pokemondetail.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import ca.keaneq.domain.model.AttackStyle
import ca.keaneq.domain.model.Role
import ca.keaneq.presentation.R
import ca.keaneq.presentation.main.mapper.color
import ca.keaneq.presentation.main.onPokemon
import ca.keaneq.presentation.pokemondetail.model.PokemonState

@Composable
fun Content(
    pokemonState: PokemonState,
    onMoveClick: (Int) -> Unit,
) {
    val color = pokemonState.pokemon.role.color
    val onColor = MaterialTheme.colors.onPokemon

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            PokemonImage(
                pokemon = pokemonState.pokemon,
                color = color,
                onColor = onColor,
            )
        }
        item {
            PillsRow(
                roleText = pokemonState.pokemon.role.text,
                attackStyleText = pokemonState.pokemon.attackStyle.text,
                color = color,
                onColor = onColor,
            )
        }
        item { PokemonStats(pokemon = pokemonState.pokemon) }
        item { PokemonEvolutions(pokemon = pokemonState.pokemon) }
        starsRows(color, onColor, pokemonState)
        pokemonState.moves.forEach { moveState ->
            item {
                Move(
                    moveState = moveState,
                    color = color,
                    onColor = onColor,
                    onClick = onMoveClick,
                )
            }
        }
    }
}

private fun LazyListScope.starsRows(
    color: Color,
    onColor: Color,
    pokemonState: PokemonState
) {
    item {
        StarsRow(
            text = stringResource(R.string.star_offense),
            color = color,
            onColor = onColor,
            score = pokemonState.pokemon.stars.offense,
            isTop = true,
        )
    }
    item {
        StarsRow(
            text = stringResource(R.string.star_endurance),
            color = color,
            onColor = onColor,
            score = pokemonState.pokemon.stars.endurance,
        )
    }
    item {
        StarsRow(
            text = stringResource(R.string.star_mobility),
            color = color,
            onColor = onColor,
            score = pokemonState.pokemon.stars.mobility,
        )
    }
    item {
        StarsRow(
            text = stringResource(R.string.star_scoring),
            color = color,
            onColor = onColor,
            score = pokemonState.pokemon.stars.scoring,
        )
    }
    item {
        StarsRow(
            text = stringResource(R.string.star_support),
            color = color,
            onColor = onColor,
            score = pokemonState.pokemon.stars.support,
            isBottom = true,
        )
    }
}

private val AttackStyle.text
    @Composable
    get() = stringResource(
        when (this) {
            AttackStyle.RANGED -> R.string.attack_style_ranged
            AttackStyle.MELEE -> R.string.attack_style_melee
            AttackStyle.UNSPECIFIED -> R.string.attack_style_unspecified
        }
    )

private val Role.text
    @Composable
    get() = stringResource(
        when (this) {
            Role.ALL_ROUNDER -> R.string.role_all_rounder
            Role.ATTACKER -> R.string.role_attacker
            Role.DEFENDER -> R.string.role_defender
            Role.SPEEDSTER -> R.string.role_speedster
            Role.SUPPORTER -> R.string.role_supporter
            else -> R.string.role_unspecified
        }
    )