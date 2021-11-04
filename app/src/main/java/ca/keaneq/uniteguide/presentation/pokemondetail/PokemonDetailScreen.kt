package ca.keaneq.uniteguide.presentation.pokemondetail

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.uniteguide.presentation.pokemondetail.component.PokemonEvolutions
import ca.keaneq.uniteguide.presentation.pokemondetail.component.PokemonImage
import ca.keaneq.uniteguide.presentation.pokemondetail.component.PokemonPillRow
import ca.keaneq.uniteguide.presentation.pokemondetail.component.PokemonStats
import ca.keaneq.uniteguide.presentation.pokemondetail.viewmodel.PokemonDetailViewModel

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
    when {
        pokemon != null -> {
            BottomSheetScaffold(
                scaffoldState = scaffoldState,
                sheetContent = {
                    Text(text = "Hello world")
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