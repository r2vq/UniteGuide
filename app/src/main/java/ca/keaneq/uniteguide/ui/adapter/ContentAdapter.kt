package ca.keaneq.uniteguide.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ListAdapter
import ca.keaneq.uniteguide.databinding.*
import ca.keaneq.uniteguide.lifecycle.Event
import ca.keaneq.uniteguide.ui.diff.ListItemDiffUtil
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemType
import ca.keaneq.uniteguide.ui.viewholder.*

class ContentAdapter(
    diffCallback: ListItemDiffUtil
) : ListAdapter<ListItem, BindableViewHolder<ListItem>>(
    diffCallback
) {
    private val _onClick: MutableLiveData<Event<String>> = MutableLiveData()
    val onClick: LiveData<Event<String>> = _onClick

    override fun getItemViewType(position: Int): Int =
        getItem(position).type.id

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindableViewHolder<ListItem> {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            ListItemType.POKEMON.id -> PokemonViewHolder(
                ListItemPokemonBinding.inflate(layoutInflater, parent, false)
            ) { pokemonId -> _onClick.postValue(Event(pokemonId)) }
            ListItemType.TITLE.id -> TitleViewHolder(
                ListItemTitleBinding.inflate(layoutInflater, parent, false)
            )
            ListItemType.IMAGE.id -> ImageViewHolder(
                ListItemPhotoBinding.inflate(layoutInflater, parent, false)
            )
            ListItemType.CHIPS.id -> ChipsViewHolder(
                ListItemChipsBinding.inflate(layoutInflater, parent, false)
            )
            ListItemType.FACTS.id -> FactsViewHolder(
                ListItemFactsBinding.inflate(layoutInflater, parent, false)
            )
            ListItemType.SUBTITLE.id -> SubtitleViewHolder(
                ListItemSubtitleBinding.inflate(layoutInflater, parent, false)
            )
            ListItemType.EVOLUTIONS.id -> EvolutionsViewHolder(
                ListItemEvolutionsBinding.inflate(layoutInflater, parent, false)
            )
            ListItemType.MOVE_SINGLE.id -> MoveSingleViewHolder(
                ListItemMoveSingleBinding.inflate(layoutInflater, parent, false)
            ) { moveId -> _onClick.postValue(Event(moveId)) }
            ListItemType.MOVE_SINGLE_COMPRESSED.id -> MoveSingleCompressedViewHolder(
                ListItemMoveSingleCompressedBinding.inflate(layoutInflater, parent, false)
            ) { moveId -> _onClick.postValue(Event(moveId)) }
            ListItemType.MOVE_ABILITY.id -> MoveAbilityViewHolder(
                ListItemMoveAbilityBinding.inflate(layoutInflater, parent, false)
            ) { moveId -> _onClick.postValue(Event(moveId)) }
            ListItemType.MOVE_ABILITY_COMPRESSED.id -> MoveAbilityCompressedViewHolder(
                ListItemMoveAbilityCompressedBinding.inflate(layoutInflater, parent, false)
            ) { moveId -> _onClick.postValue(Event(moveId)) }
            ListItemType.HOME_ITEM.id -> HomeItemViewHolder(
                ListItemHomeBinding.inflate(layoutInflater, parent, false)
            ) { itemId -> _onClick.postValue(Event(itemId)) }
            else -> UnknownViewHolder(
                ListItemEmptyBinding.inflate(layoutInflater, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: BindableViewHolder<ListItem>, position: Int) =
        holder.bind(getItem(position))
}