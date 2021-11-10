package ca.keaneq.presentation.pokemondetail

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
import ca.keaneq.domain.model.Pokemon
import ca.keaneq.presentation.R
import ca.keaneq.presentation.model.color
import ca.keaneq.presentation.model.onColor
import ca.keaneq.presentation.pokemondetail.component.*
import ca.keaneq.presentation.pokemondetail.model.SheetData
import ca.keaneq.presentation.pokemondetail.viewmodel.PokemonDetailViewModel
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
    when {
        pokemon != null -> {
            Success(
                pokemon = pokemon,
                sheet = currentSheet,
                sheetState = modalBottomSheetState,
                onCloseBottomSheet = { scope.launch { modalBottomSheetState.hide() } },
                onOpenBottomSheet = { title, body, image ->
                    currentSheet = SheetData(
                        image = image,
                        title = title,
                        body = body
                    )
                    scope.launch { modalBottomSheetState.show() }
                }
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Success(
    pokemon: Pokemon,
    sheet: SheetData?,
    sheetState: ModalBottomSheetState,
    onCloseBottomSheet: () -> Unit,
    onOpenBottomSheet: (title: String, body: String, image: String) -> Unit,
) {
    ModalBottomSheetLayout(
        sheetShape = CutCornerShape(topEnd = 40.dp),
        sheetContent = {
            SheetContent(
                sheet = sheet,
                onCloseBottomSheet = onCloseBottomSheet
            )
        },
        sheetState = sheetState,
    ) {
        Content(
            pokemon = pokemon,
            onOpenBottomSheet = onOpenBottomSheet
        )
    }
}

@Composable
private fun SheetContent(
    sheet: SheetData?,
    onCloseBottomSheet: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clickable { onCloseBottomSheet() }
    ) {
        sheet
            ?.let { sheet -> MoveSheet(sheet = sheet) }
            ?: run {
                Text(stringResource(id = R.string.error_missing_value))
                onCloseBottomSheet()
            }
    }
}

@Composable
private fun Content(
    pokemon: Pokemon,
    onOpenBottomSheet: (title: String, body: String, image: String) -> Unit,
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item { PokemonImage(pokemon = pokemon) }
        item { PokemonPillRow(pokemon = pokemon) }
        item { PokemonStats(pokemon = pokemon) }
        item { PokemonEvolutions(pokemon = pokemon) }
        item {
            Move(pokemon.passive, pokemon.role.color, pokemon.role.onColor) {
                onOpenBottomSheet(
                    pokemon.passive.name,
                    pokemon.passive.description,
                    pokemon.passive.image,
                )
            }
        }
        item {
            Move(pokemon.basic, pokemon.role.color, pokemon.role.onColor) {
                onOpenBottomSheet(
                    pokemon.basic.name,
                    pokemon.basic.description,
                    pokemon.basic.image,
                )
            }
        }
        pokemon.moveset.forEach { moveset ->
            item {
                Moveset(moveset, pokemon.role.color, pokemon.role.onColor, onOpenBottomSheet)
            }
        }
        item {
            Move(pokemon.unite, pokemon.role.color, pokemon.role.onColor) {
                onOpenBottomSheet(
                    pokemon.unite.name,
                    pokemon.unite.description,
                    pokemon.unite.image,
                )
            }
        }
    }
}