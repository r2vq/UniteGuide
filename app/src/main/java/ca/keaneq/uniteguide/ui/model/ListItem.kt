package ca.keaneq.uniteguide.ui.model

import androidx.annotation.ColorInt

enum class ListItemType(
    val id: Int
) {
    POKEMON(0)
}

sealed class ListItem {
    abstract val type: ListItemType
    abstract fun areItemsTheSame(newItem: ListItem): Boolean
    abstract fun areContentsTheSame(newItem: ListItem): Boolean
}

data class ListItemPokemon(
    val id: String,
    val name: String,
    @ColorInt val backgroundColor: Int?,
    val image: String?
) : ListItem() {
    override val type: ListItemType = ListItemType.POKEMON

    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemPokemon
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemPokemon
            && newItem.id == id
            && newItem.name == name
            && newItem.image == image
}