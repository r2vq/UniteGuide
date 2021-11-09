package ca.keaneq.presentation.main

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.keaneq.presentation.R

@Composable
fun NavigationDrawerItem(
    text: String = "",
    @DrawableRes icon: Int = R.drawable.ic_pokeball_black,
    backgroundColor: Color = Color.Transparent,
    foregroundColor: Color = Color.DarkGray,
    onClick: () -> Unit = {},
) {
    Surface(
        color = backgroundColor,
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp),
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = text,
                    modifier = Modifier.size(40.dp),
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            Divider(
                color = foregroundColor,
                thickness = 1.dp,
            )
        }
    }
}

@Preview
@Composable
fun NavigationDrawerItemPreview() {
    NavigationDrawerItem(
        "Pokémon",
        backgroundColor = MaterialTheme.colors.background
    )
}