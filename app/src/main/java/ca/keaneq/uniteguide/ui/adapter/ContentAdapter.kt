package ca.keaneq.uniteguide.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ListAdapter
import ca.keaneq.uniteguide.databinding.ListItemEmptyBinding
import ca.keaneq.uniteguide.databinding.ListItemPhotoBinding
import ca.keaneq.uniteguide.databinding.ListItemPokemonBinding
import ca.keaneq.uniteguide.databinding.ListItemTitleBinding
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
            else -> UnknownViewHolder(
                ListItemEmptyBinding.inflate(layoutInflater, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: BindableViewHolder<ListItem>, position: Int) =
        holder.bind(getItem(position))
}