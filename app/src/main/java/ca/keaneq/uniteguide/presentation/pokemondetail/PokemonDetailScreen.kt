package ca.keaneq.uniteguide.presentation.pokemondetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.uniteguide.presentation.pokemondetail.component.*
import ca.keaneq.uniteguide.presentation.pokemondetail.model.SheetData
import ca.keaneq.uniteguide.presentation.pokemondetail.viewmodel.PokemonDetailViewModel
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val pokemon = state.pokemon
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState)
    var currentSheet: SheetData? by remember { mutableStateOf(null) }
    viewModel.sheet.value
        ?.getContentIfNotHandled()
        ?.also {
            currentSheet = it
            scope.launch { bottomSheetState.expand() }
        }
    if (bottomSheetState.isCollapsed) {
        currentSheet = null
    }
    when {
        pokemon != null -> {
            BottomSheetScaffold(
                scaffoldState = scaffoldState,
                sheetContent = {
                    Box(
                        modifier = Modifier
                            .clickable { scope.launch { bottomSheetState.collapse() } }
                    ) {
                        currentSheet?.let { sheet -> MoveSheet(sheet = sheet) }
                    }
                },
                sheetPeekHeight = 0.dp,
                sheetShape = CutCornerShape(topEnd = 40.dp),
            ) {
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    item { PokemonImage(pokemon = pokemon) }
                    item { PokemonPillRow(pokemon = pokemon) }
                    item { PokemonStats(pokemonItem = pokemon) }
                    item { PokemonEvolutions(pokemon = pokemon) }
                    pokemon.moves.forEach { move ->
                        item { Move(move) { viewModel.onItemClick(move.id) } }
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