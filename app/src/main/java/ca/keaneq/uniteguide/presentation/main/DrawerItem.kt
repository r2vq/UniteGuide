package ca.keaneq.uniteguide.presentation.main

import android.content.Context
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ca.keaneq.uniteguide.R

enum class DrawerItem(
    @StringRes val text: Int,
    @DrawableRes val icon: Int,
    val onClick: (Context/*, NavController*/) -> Unit
) {
    POKEMON(R.string.title_pokemon, R.drawable.ic_pokeball_black, { context ->
        Toast.makeText(context, "Click Pokemon", Toast.LENGTH_SHORT).show()
    }),
    ABOUT(R.string.title_about, R.drawable.ic_info_black_24dp, { context ->
        Toast.makeText(context, "Click About", Toast.LENGTH_SHORT).show()
    }),
}

@Composable
fun DrawerItem.ToNavigationDrawerItem() {
    val context = LocalContext.current
    NavigationDrawerItem(
        text = stringResource(id = text),
        icon = icon,
        backgroundColor = MaterialTheme.colors.background,
        foregroundColor = MaterialTheme.colors.onBackground,
        onClick = { onClick(context) }
    )
}

@Preview
@Composable
fun DrawerItemPreview() {
    DrawerItem.POKEMON.ToNavigationDrawerItem()
}