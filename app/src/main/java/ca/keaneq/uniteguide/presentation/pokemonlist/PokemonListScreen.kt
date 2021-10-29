package ca.keaneq.uniteguide.presentation.pokemonlist

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ca.keaneq.uniteguide.R

@Composable
fun PokemonListScreen() {
    Text(text = stringResource(id = R.string.title_pokemon))
}

@Preview(showBackground = true)
@Composable
fun PokemonScreenPreview() {
    PokemonListScreen()
}