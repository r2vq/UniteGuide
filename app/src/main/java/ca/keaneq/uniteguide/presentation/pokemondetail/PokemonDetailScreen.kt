package ca.keaneq.uniteguide.presentation.pokemondetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.presentation.model.MovesetItem
import ca.keaneq.uniteguide.presentation.model.SingleMoveItem
import ca.keaneq.uniteguide.presentation.pokemondetail.component.*
import ca.keaneq.uniteguide.presentation.pokemondetail.model.SheetData
import ca.keaneq.uniteguide.presentation.pokemondetail.viewmodel.PokemonDetailViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val pokemon = state.pokemon
    val scope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    var currentSheet: SheetData? by remember { mutableStateOf(null) }
    if (!modalBottomSheetState.isVisible) {
        currentSheet = null
    }
    viewModel.sheet.value
        ?.getContentIfNotHandled()
        ?.also {
            currentSheet = it
            scope.launch { modalBottomSheetState.show() }
        }
    when {
        pokemon != null -> {
            ModalBottomSheetLayout(
                sheetShape = CutCornerShape(topEnd = 40.dp),
                sheetContent = {
                    Box(
                        modifier = Modifier
                            .clickable { scope.launch { modalBottomSheetState.hide() } }
                    ) {
                        currentSheet
                            ?.let { sheet -> MoveSheet(sheet = sheet) }
                            ?: run {
                                Text(stringResource(id = R.string.error_missing_value))
                                scope.launch { modalBottomSheetState.hide() }
                            }
                    }
                },
                sheetState = modalBottomSheetState,
            ) {
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    item { PokemonImage(pokemon = pokemon) }
                    item { PokemonPillRow(pokemon = pokemon) }
                    item { PokemonStats(pokemonItem = pokemon) }
                    item { PokemonEvolutions(pokemon = pokemon) }
                    pokemon.moves.forEach { move ->
                        item {
                            if (move is SingleMoveItem) {
                                Move(move) {
                                    viewModel.onItemClick(move.id)
                                }
                            } else if (move is MovesetItem) {
                                Moveset(move) {
                                    viewModel.onItemClick(move.id)
                                }
                            }
                        }
                    }
                }
            }
        }
        state.isLoading -> {
            Text(text = "Loading")
        }
        state.error.isNotBlank() -> {
            Text(text = "Error: ${state.error}")
        }
    }
}