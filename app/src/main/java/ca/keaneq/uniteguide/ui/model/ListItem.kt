package ca.keaneq.uniteguide.ui.model

import androidx.annotation.ColorInt
import androidx.annotation.StringRes

enum class ListItemType(
    val id: Int
) {
    POKEMON(0),
    TITLE(1),
    IMAGE(2),
    CHIPS(3),
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

data class ListItemTitle(
    val id: String,
    val text: String,
    @ColorInt val backgroundColor: Int?
) : ListItem() {
    override val type: ListItemType = ListItemType.TITLE

    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemTitle
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemTitle
            && newItem.id == id
            && newItem.text == text
}

data class ListItemImage(
    val id: String,
    val imageUrl: String?,
    @ColorInt val backgroundColor: Int?
) : ListItem() {
    override val type: ListItemType = ListItemType.IMAGE

    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemImage
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemImage
            && newItem.id == id
            && newItem.imageUrl == imageUrl
            && newItem.backgroundColor == backgroundColor
}

data class ListItemChips(
    val id: String,
    val leftChip: Chip,
    val rightChip: Chip,
) : ListItem() {
    override val type: ListItemType = ListItemType.CHIPS

    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemChips
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemChips
            && newItem.id == id
            && leftChip.areContentsTheSame(newItem.leftChip)
            && rightChip.areContentsTheSame(newItem.rightChip)

    data class Chip(
        @ColorInt val backgroundColor: Int?,
        @StringRes val text: Int?
    ) {
        fun areContentsTheSame(newItem: Chip): Boolean = newItem.backgroundColor == backgroundColor
                && newItem.text == text
    }
}