package ca.keaneq.uniteguide.ui.model

import android.content.Context
import androidx.annotation.AttrRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class ListItemType(
    val id: Int
) {
    FACTS(4),
    SUBTITLE(5),
    EVOLUTIONS(6),
    MOVE_SINGLE(7),
    MOVE_SINGLE_COMPRESSED(8),
    MOVE_ABILITY(9),
    MOVE_ABILITY_COMPRESSED(10),
    HOME_ITEM(11),
    POKEMON_ALL_ROUNDER(12),
    POKEMON_ATTACKER(13),
    POKEMON_DEFENDER(14),
    POKEMON_SPEEDSTER(15),
    POKEMON_SUPPORTER(16),
    TITLE_ALL_ROUNDER(17),
    TITLE_ATTACKER(18),
    TITLE_DEFENDER(19),
    TITLE_SPEEDSTER(20),
    TITLE_SUPPORTER(21),
    IMAGE_ALL_ROUNDER(22),
    IMAGE_ATTACKER(23),
    IMAGE_DEFENDER(24),
    IMAGE_SPEEDSTER(25),
    IMAGE_SUPPORTER(26),
    CHIPS_ALL_ROUNDER(27),
    CHIPS_ATTACKER(28),
    CHIPS_DEFENDER(29),
    CHIPS_SPEEDSTER(30),
    CHIPS_SUPPORTER(31),
}

sealed class ListItem {
    abstract val type: ListItemType
    abstract fun areItemsTheSame(newItem: ListItem): Boolean
    abstract fun areContentsTheSame(newItem: ListItem): Boolean
}

data class ListItemPokemon(
    val id: String,
    val name: String,
    val image: String?,
    override val type: ListItemType,
) : ListItem() {
    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemPokemon
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemPokemon
            && newItem.id == id
            && newItem.name == name
            && newItem.image == image
            && newItem.type == type
}

data class ListItemTitle(
    val id: String,
    val text: String,
    override val type: ListItemType,
) : ListItem() {
    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemTitle
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemTitle
            && newItem.id == id
            && newItem.text == text
            && newItem.type == type
}

data class ListItemImage(
    val id: String,
    val imageUrl: String?,
    override val type: ListItemType,
) : ListItem() {

    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemImage
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemImage
            && newItem.id == id
            && newItem.imageUrl == imageUrl
            && newItem.type == type
}

data class ListItemChips(
    val id: String,
    val leftChip: Chip,
    val rightChip: Chip,
    override val type: ListItemType,
) : ListItem() {
    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemChips
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemChips
            && newItem.id == id
            && leftChip.areContentsTheSame(newItem.leftChip)
            && rightChip.areContentsTheSame(newItem.rightChip)
            && newItem.type == type

    data class Chip(
        @AttrRes val backgroundColor: Int?,
        @AttrRes val textColor: Int?,
        @StringRes val text: Int?
    ) {
        fun areContentsTheSame(newItem: Chip): Boolean = newItem.backgroundColor == backgroundColor
                && newItem.textColor == textColor
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
    val description: String,
    val cooldown: String,
    val upgrade: Int,
    val upgrade1Name: String?,
    val upgrade1Description: String?,
    val upgrade1Cooldown: String?,
    val upgrade1Image: String?,
    val upgrade2Name: String?,
    val upgrade2Description: String?,
    val upgrade2Cooldown: String?,
    val upgrade2Image: String?,
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
                && newItem.cooldown == cooldown
                && newItem.upgrade == upgrade
                && newItem.upgrade1Name == upgrade1Name
                && newItem.upgrade1Description == upgrade1Description
                && newItem.upgrade1Cooldown == upgrade1Cooldown
                && newItem.upgrade1Image == upgrade1Image
                && newItem.upgrade2Name == upgrade2Name
                && newItem.upgrade2Description == upgrade2Description
                && newItem.upgrade2Cooldown == upgrade2Cooldown
                && newItem.upgrade2Image == upgrade2Image

    fun compress(): ListItemMoveAbilityCompressed = ListItemMoveAbilityCompressed(
        id = id,
        image = image,
        name = name,
        description = description,
        cooldown = cooldown,
        upgrade = upgrade,
        upgrade1Name = upgrade1Name,
        upgrade1Description = upgrade1Description,
        upgrade1Cooldown = upgrade1Cooldown,
        upgrade1Image = upgrade1Image,
        upgrade2Name = upgrade2Name,
        upgrade2Description = upgrade2Description,
        upgrade2Cooldown = upgrade2Cooldown,
        upgrade2Image = upgrade2Image,
    )
}

data class ListItemMoveAbilityCompressed(
    val id: String,
    val image: String,
    val name: String,
    val description: String,
    val cooldown: String,
    val upgrade: Int,
    val upgrade1Name: String?,
    val upgrade1Description: String?,
    val upgrade1Cooldown: String?,
    val upgrade1Image: String?,
    val upgrade2Name: String?,
    val upgrade2Description: String?,
    val upgrade2Cooldown: String?,
    val upgrade2Image: String?,
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
                && newItem.cooldown == cooldown
                && newItem.upgrade == upgrade
                && newItem.upgrade1Name == upgrade1Name
                && newItem.upgrade1Description == upgrade1Description
                && newItem.upgrade1Cooldown == upgrade1Cooldown
                && newItem.upgrade1Image == upgrade1Image
                && newItem.upgrade2Name == upgrade2Name
                && newItem.upgrade2Description == upgrade2Description
                && newItem.upgrade2Cooldown == upgrade2Cooldown
                && newItem.upgrade2Image == upgrade2Image

    fun expand(): ListItemMoveAbility = ListItemMoveAbility(
        id = id,
        image = image,
        name = name,
        description = description,
        cooldown = cooldown,
        upgrade = upgrade,
        upgrade1Name = upgrade1Name,
        upgrade1Description = upgrade1Description,
        upgrade1Cooldown = upgrade1Cooldown,
        upgrade1Image = upgrade1Image,
        upgrade2Name = upgrade2Name,
        upgrade2Description = upgrade2Description,
        upgrade2Cooldown = upgrade2Cooldown,
        upgrade2Image = upgrade2Image,
    )
}

data class ListItemHome(
    val id: String,
    val title: String,
    @DrawableRes val image: Int,
    @AttrRes val color: Int,
) : ListItem() {
    override val type: ListItemType = ListItemType.HOME_ITEM

    override fun areItemsTheSame(newItem: ListItem): Boolean = newItem is ListItemHome
            && newItem.id == id

    override fun areContentsTheSame(newItem: ListItem): Boolean = newItem is ListItemHome
            && newItem.id == id
            && newItem.title == title
            && newItem.image == image
            && newItem.color == color
}