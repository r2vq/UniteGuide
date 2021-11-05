package ca.keaneq.uniteguide.presentation.pokemondetail.model

import ca.keaneq.uniteguide.presentation.model.MoveItem

data class SheetData(
    val id: Int,
    val image: String,
    val title: String,
    val body: String,
)

fun MoveItem.toSheetData(): SheetData = SheetData(
    id = id,
    image = image,
    title = name,
    body = description,
)