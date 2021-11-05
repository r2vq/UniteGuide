package ca.keaneq.uniteguide.presentation.pokemondetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ca.keaneq.uniteguide.presentation.pokemondetail.model.SheetData
import coil.compose.rememberImagePainter

@Composable
fun MoveSheet(sheet: SheetData) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(sheet.image),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(vertical = 16.dp)
        )
        Text(
            text = sheet.title,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Text(
            text = sheet.body,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 32.dp)
        )
    }
}