package ca.keaneq.uniteguide.ui.model

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.StringRes

enum class ListItemType(
    val id: Int
) {
    POKEMON(0),
    TITLE(1),
    IMAGE(2),
    CHIPS(3),
    FACTS(4),
    SUBTITLE(5),
    EVOLUTIONS(6),
    MOVE_SINGLE(7),
    MOVE_SINGLE_COMPRESSED(8),
    MOVE_ABILITY(9),
    MOVE_ABILITY_COMPRESSED(10),
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

data class ListItemFacts(
    val id: String,
    @StringRes val leftFact: Int?,
    @StringRes val centerFact: Int?,
    @StringRes val rightFact: Int?
) : ListItem() {
    override val type: ListItemType = ListItemType.FACTS

    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemFacts
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemFacts
            && newItem.id == id
            && newItem.leftFact == leftFact
            && newItem.centerFact == centerFact
            && newItem.rightFact == rightFact
}

abstract class ListItemSubtitle : ListItem() {
    override val type: ListItemType = ListItemType.SUBTITLE
    abstract fun getText(context: Context): String
}

data class ListItemResSubtitle(
    val id: String,
    @StringRes private val stringRes: Int
) : ListItemSubtitle() {
    override fun getText(context: Context): String = context
        .getString(stringRes)

    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemResSubtitle
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemResSubtitle
            && newItem.id == id
            && newItem.stringRes == stringRes
}

data class ListItemEvolutions(
    val id: String,
    val species: List<Species>
) : ListItem() {
    override val type: ListItemType = ListItemType.EVOLUTIONS

    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemEvolutions
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemEvolutions
            && newItem.id == id
            && newItem.species == species

    data class Species(
        val name: String,
        val level: Int,
        val image: String,
    )
}

data class ListItemMoveSingle(
    val id: String,
    val image: String,
    val name: String,
    val description: String
) : ListItem() {
    override val type: ListItemType = ListItemType.MOVE_SINGLE

    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemMoveSingle
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemMoveSingle
            && newItem.id == id
            && newItem.image == image
            && newItem.name == name
            && newItem.description == description

    fun compress() = ListItemMoveSingleCompressed(
        id = id,
        image = image,
        name = name,
        description = description
    )
}

data class ListItemMoveSingleCompressed(
    val id: String,
    val image: String,
    val name: String,
    val description: String
) : ListItem() {
    override val type: ListItemType = ListItemType.MOVE_SINGLE_COMPRESSED

    override fun areItemsTheSame(newItem: ListItem): Boolean =
        newItem is ListItemMoveSingleCompressed
                && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean =
        newItem is ListItemMoveSingleCompressed
                && newItem.id == id
                && newItem.image == image
                && newItem.name == name

    fun expand() = ListItemMoveSingle(
        id = id,
        image = image,
        name = name,
        description = description
    )
}

data class ListItemMoveAbility(
    val id: String,
    val image: String,
    val name: String,
    val description: String
) : ListItem() {
    override val type: ListItemType = ListItemType.MOVE_ABILITY

    override fun areItemsTheSame(newItem: ListItem): Boolean =
        newItem is ListItemMoveAbility
                && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean =
        newItem is ListItemMoveAbility
                && newItem.id == id
                && newItem.image == image
                && newItem.name == name
                && newItem.description == description

    fun compress(): ListItemMoveAbilityCompressed {
        return ListItemMoveAbilityCompressed(
            id = id,
            image = image,
            name = name,
            description = description
        )
    }
}

data class ListItemMoveAbilityCompressed(
    val id: String,
    val image: String,
    val name: String,
    val description: String
) : ListItem() {
    override val type: ListItemType = ListItemType.MOVE_ABILITY_COMPRESSED

    override fun areItemsTheSame(newItem: ListItem): Boolean =
        newItem is ListItemMoveAbilityCompressed
                && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean =
        newItem is ListItemMoveAbilityCompressed
                && newItem.id == id
                && newItem.image == image
                && newItem.name == name
                && newItem.description == description

    fun expand(): ListItemMoveAbility {
        return ListItemMoveAbility(
            id = id,
            image = image,
            name = name,
            description = description
        )
    }
}