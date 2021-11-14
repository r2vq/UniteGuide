package ca.keaneq.presentation.pokemondetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.presentation.R
import ca.keaneq.presentation.model.color
import ca.keaneq.presentation.model.onColor
import ca.keaneq.presentation.pokemondetail.component.*
import ca.keaneq.presentation.pokemondetail.model.PokemonState
import ca.keaneq.presentation.pokemondetail.viewmodel.PokemonDetailViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val pokemon = state.pokemon
    when {
        pokemon != null -> {
            Content(
                pokemonState = pokemon,
                onMoveClick = viewModel::onMoveClick
            )
        }
        state.isLoading -> {
            Text(text = "Loading")
        }
        !state.error.isNullOrBlank() -> {
            Text(text = "Error: ${state.error}")
        }
    }
}

@Composable
private fun Content(
    pokemonState: PokemonState,
    onMoveClick: (Int) -> Unit,
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item { PokemonImage(pokemon = pokemonState.pokemon) }
        item { PokemonPillRow(pokemon = pokemonState.pokemon) }
        item { PokemonStats(pokemon = pokemonState.pokemon) }
        item { PokemonEvolutions(pokemon = pokemonState.pokemon) }
        item {
            StarsRow(
                text = stringResource(R.string.star_offense),
                color = pokemonState.pokemon.role.color,
                onColor = pokemonState.pokemon.role.onColor,
                score = pokemonState.pokemon.stars.offense,
            )
        }
        item {
            StarsRow(
                text = stringResource(R.string.star_endurance),
                color = pokemonState.pokemon.role.color,
                onColor = pokemonState.pokemon.role.onColor,
                score = pokemonState.pokemon.stars.endurance,
            )
        }
        item {
            StarsRow(
                text = stringResource(R.string.star_mobility),
                color = pokemonState.pokemon.role.color,
                onColor = pokemonState.pokemon.role.onColor,
                score = pokemonState.pokemon.stars.mobility,
            )
        }
        item {
            StarsRow(
                text = stringResource(R.string.star_scoring),
                color = pokemonState.pokemon.role.color,
                onColor = pokemonState.pokemon.role.onColor,
                score = pokemonState.pokemon.stars.scoring,
            )
        }
        item {
            StarsRow(
                text = stringResource(R.string.star_support),
                color = pokemonState.pokemon.role.color,
                onColor = pokemonState.pokemon.role.onColor,
                score = pokemonState.pokemon.stars.support,
            )
        }
        pokemonState.moves.forEach { moveState ->
            item {
                Move(
                    moveState = moveState,
                    color = pokemonState.pokemon.role.color,
                    onColor = pokemonState.pokemon.role.onColor,
                    onClick = onMoveClick,
                )
            }
        }
    }
}

@Composable
fun StarsRow(
    text: String,
    score: Float,
    color: Color,
    onColor: Color,
) {
    Row(
        modifier = Modifier
            .padding(
                horizontal = 4.dp,
                vertical = 8.dp
            )
    ) {
        Text(
            text = text,
            maxLines = 1,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .weight(0.2f)
                .padding(start = 8.dp)
        )
        Box(
            modifier = Modifier
                .height(20.dp)
                .weight(0.8f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        start = 8.dp,
                        end = 8.dp
                    )
                    .fillMaxWidth()
            ) {
                for (i in 1..5) {
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxHeight()
                            .clip(
                                RoundedCornerShape(
                                    topStart = if (i == 1) 20.dp else 0.dp,
                                    bottomStart = if (i == 1) 20.dp else 0.dp,
                                )
                            )
                            .background(color)
                    )
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxHeight()
                            .clip(
                                RoundedCornerShape(
                                    topEnd = if (i == 5) 20.dp else 0.dp,
                                    bottomEnd = if (i == 5) 20.dp else 0.dp,
                                )
                            )
                            .background(color)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 2.dp,
                        bottom = 2.dp,
                    )
                    .fillMaxWidth()
            ) {
                for (i in 0 until 5) {
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxHeight()
                            .padding(start = 2.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = if (i == 0) 20.dp else 0.dp,
                                    bottomStart = if (i == 0) 20.dp else 0.dp,
                                )
                            )
                            .background(
                                if (score > i) {
                                    onColor
                                } else {
                                    color
                                }
                            )
                    )
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxHeight()
                            .padding(end = 2.dp)
                            .clip(
                                RoundedCornerShape(
                                    topEnd = if (i == 4) 20.dp else 0.dp,
                                    bottomEnd = if (i == 4) 20.dp else 0.dp,
                                )
                            )
                            .background(
                                if (score > i + 0.5) {
                                    onColor
                                } else {
                                    color
                                }
                            )
                    )
                }
            }
        }
    }
}