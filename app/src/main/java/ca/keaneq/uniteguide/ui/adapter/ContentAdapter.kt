package ca.keaneq.uniteguide.ui.adapter

import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StyleRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ListAdapter
import ca.keaneq.uniteguide.R
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
            ListItemType.FACTS.id -> FactsViewHolder(
                ListItemFactsBinding.inflate(layoutInflater, parent, false)
            )
            ListItemType.SUBTITLE.id -> SubtitleViewHolder(
                ListItemSubtitleBinding.inflate(layoutInflater, parent, false)
            )
            ListItemType.EVOLUTIONS.id -> EvolutionsViewHolder(
                ListItemEvolutionsBinding.inflate(layoutInflater, parent, false)
            )
            ListItemType.HOME_ITEM.id -> HomeItemViewHolder(
                ListItemHomeBinding.inflate(layoutInflater, parent, false)
            ) { itemId -> _onClick.postValue(Event(itemId)) }
            // pokemon
            ListItemType.POKEMON_ALL_ROUNDER.id -> pokemonHolder(R.style.PokemonAllRounder, parent)
            ListItemType.POKEMON_ATTACKER.id -> pokemonHolder(R.style.PokemonAttacker, parent)
            ListItemType.POKEMON_DEFENDER.id -> pokemonHolder(R.style.PokemonDefender, parent)
            ListItemType.POKEMON_SPEEDSTER.id -> pokemonHolder(R.style.PokemonSpeedster, parent)
            ListItemType.POKEMON_SUPPORTER.id -> pokemonHolder(R.style.PokemonSupporter, parent)
            // title
            ListItemType.TITLE_ALL_ROUNDER.id -> titleHolder(R.style.PokemonAllRounder, parent)
            ListItemType.TITLE_ATTACKER.id -> titleHolder(R.style.PokemonAttacker, parent)
            ListItemType.TITLE_DEFENDER.id -> titleHolder(R.style.PokemonDefender, parent)
            ListItemType.TITLE_SPEEDSTER.id -> titleHolder(R.style.PokemonSpeedster, parent)
            ListItemType.TITLE_SUPPORTER.id -> titleHolder(R.style.PokemonSupporter, parent)
            // image
            ListItemType.IMAGE_ALL_ROUNDER.id -> imageHolder(R.style.PokemonAllRounder, parent)
            ListItemType.IMAGE_ATTACKER.id -> imageHolder(R.style.PokemonAttacker, parent)
            ListItemType.IMAGE_DEFENDER.id -> imageHolder(R.style.PokemonDefender, parent)
            ListItemType.IMAGE_SPEEDSTER.id -> imageHolder(R.style.PokemonSpeedster, parent)
            ListItemType.IMAGE_SUPPORTER.id -> imageHolder(R.style.PokemonSupporter, parent)
            // chips
            ListItemType.CHIPS_ALL_ROUNDER.id -> chipsHolder(R.style.PokemonAllRounder, parent)
            ListItemType.CHIPS_ATTACKER.id -> chipsHolder(R.style.PokemonAttacker, parent)
            ListItemType.CHIPS_DEFENDER.id -> chipsHolder(R.style.PokemonDefender, parent)
            ListItemType.CHIPS_SPEEDSTER.id -> chipsHolder(R.style.PokemonSpeedster, parent)
            ListItemType.CHIPS_SUPPORTER.id -> chipsHolder(R.style.PokemonSupporter, parent)
            // move single
            ListItemType.MOVE_SINGLE_ALL_ROUNDER.id -> moveSingleHolder(
                R.style.PokemonAllRounder,
                parent
            )
            ListItemType.MOVE_SINGLE_ATTACKER.id -> moveSingleHolder(
                R.style.PokemonAttacker,
                parent
            )
            ListItemType.MOVE_SINGLE_DEFENDER.id -> moveSingleHolder(
                R.style.PokemonDefender,
                parent
            )
            ListItemType.MOVE_SINGLE_SPEEDSTER.id -> moveSingleHolder(
                R.style.PokemonSpeedster,
                parent
            )
            ListItemType.MOVE_SINGLE_SUPPORTER.id -> moveSingleHolder(
                R.style.PokemonSupporter,
                parent
            )
            // move ability compressed
            ListItemType.MOVE_SINGLE_COMPRESSED_ALL_ROUNDER.id -> moveSingleCompressedHolder(
                R.style.PokemonAllRounder,
                parent
            )
            ListItemType.MOVE_SINGLE_COMPRESSED_ATTACKER.id -> moveSingleCompressedHolder(
                R.style.PokemonAttacker,
                parent
            )
            ListItemType.MOVE_SINGLE_COMPRESSED_DEFENDER.id -> moveSingleCompressedHolder(
                R.style.PokemonDefender,
                parent
            )
            ListItemType.MOVE_SINGLE_COMPRESSED_SPEEDSTER.id -> moveSingleCompressedHolder(
                R.style.PokemonSpeedster,
                parent
            )
            ListItemType.MOVE_SINGLE_COMPRESSED_SUPPORTER.id -> moveSingleCompressedHolder(
                R.style.PokemonSupporter,
                parent
            )
            // move ability
            ListItemType.MOVE_ABILITY_ALL_ROUNDER.id -> moveAbilityHolder(
                R.style.PokemonAllRounder,
                parent
            )
            ListItemType.MOVE_ABILITY_ATTACKER.id -> moveAbilityHolder(
                R.style.PokemonAttacker,
                parent
            )
            ListItemType.MOVE_ABILITY_DEFENDER.id -> moveAbilityHolder(
                R.style.PokemonDefender,
                parent
            )
            ListItemType.MOVE_ABILITY_SPEEDSTER.id -> moveAbilityHolder(
                R.style.PokemonSpeedster,
                parent
            )
            ListItemType.MOVE_ABILITY_SUPPORTER.id -> moveAbilityHolder(
                R.style.PokemonSupporter,
                parent
            )
            // move ability compressed
            ListItemType.MOVE_ABILITY_COMPRESSED_ALL_ROUNDER.id -> moveAbilityCompressedHolder(
                R.style.PokemonAllRounder,
                parent
            )
            ListItemType.MOVE_ABILITY_COMPRESSED_ATTACKER.id -> moveAbilityCompressedHolder(
                R.style.PokemonAttacker,
                parent
            )
            ListItemType.MOVE_ABILITY_COMPRESSED_DEFENDER.id -> moveAbilityCompressedHolder(
                R.style.PokemonDefender,
                parent
            )
            ListItemType.MOVE_ABILITY_COMPRESSED_SPEEDSTER.id -> moveAbilityCompressedHolder(
                R.style.PokemonSpeedster,
                parent
            )
            ListItemType.MOVE_ABILITY_COMPRESSED_SUPPORTER.id -> moveAbilityCompressedHolder(
                R.style.PokemonSupporter,
                parent
            )
            else -> UnknownViewHolder(
                ListItemEmptyBinding.inflate(layoutInflater, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: BindableViewHolder<ListItem>, position: Int) =
        holder.bind(getItem(position))

    private fun chipsHolder(
        @StyleRes style: Int,
        parent: ViewGroup
    ): BindableViewHolder<ListItem> = ContextThemeWrapper(parent.context, style)
        .let { themedContext -> LayoutInflater.from(themedContext) }
        .inflate(R.layout.list_item_chips, parent, false)
        .let { view -> ListItemChipsBinding.bind(view) }
        .let { binding -> ChipsViewHolder(binding) }

    private fun imageHolder(
        @StyleRes style: Int,
        parent: ViewGroup
    ): BindableViewHolder<ListItem> = ContextThemeWrapper(parent.context, style)
        .let { themedContext -> LayoutInflater.from(themedContext) }
        .inflate(R.layout.list_item_photo, parent, false)
        .let { view -> ListItemPhotoBinding.bind(view) }
        .let { binding -> ImageViewHolder(binding) }

    private fun moveAbilityCompressedHolder(
        @StyleRes style: Int,
        parent: ViewGroup
    ): BindableViewHolder<ListItem> = ContextThemeWrapper(parent.context, style)
        .let { themedContext -> LayoutInflater.from(themedContext) }
        .inflate(R.layout.list_item_move_ability_compressed, parent, false)
        .let { view -> ListItemMoveAbilityCompressedBinding.bind(view) }
        .let { binding ->
            MoveAbilityCompressedViewHolder(binding) { itemId ->
                _onClick.postValue(Event(itemId))
            }
        }

    private fun moveAbilityHolder(
        @StyleRes style: Int,
        parent: ViewGroup
    ): BindableViewHolder<ListItem> = ContextThemeWrapper(parent.context, style)
        .let { themedContext -> LayoutInflater.from(themedContext) }
        .inflate(R.layout.list_item_move_ability, parent, false)
        .let { view -> ListItemMoveAbilityBinding.bind(view) }
        .let { binding -> MoveAbilityViewHolder(binding) { itemId -> _onClick.postValue(Event(itemId)) } }

    private fun moveSingleCompressedHolder(
        @StyleRes style: Int,
        parent: ViewGroup
    ): BindableViewHolder<ListItem> = ContextThemeWrapper(parent.context, style)
        .let { themedContext -> LayoutInflater.from(themedContext) }
        .inflate(R.layout.list_item_move_single_compressed, parent, false)
        .let { view -> ListItemMoveSingleCompressedBinding.bind(view) }
        .let { binding ->
            MoveSingleCompressedViewHolder(binding) { itemId ->
                _onClick.postValue(Event(itemId))
            }
        }

    private fun moveSingleHolder(
        @StyleRes style: Int,
        parent: ViewGroup
    ): BindableViewHolder<ListItem> = ContextThemeWrapper(parent.context, style)
        .let { themedContext -> LayoutInflater.from(themedContext) }
        .inflate(R.layout.list_item_move_single, parent, false)
        .let { view -> ListItemMoveSingleBinding.bind(view) }
        .let { binding -> MoveSingleViewHolder(binding) { itemId -> _onClick.postValue(Event(itemId)) } }

    private fun pokemonHolder(
        @StyleRes style: Int,
        parent: ViewGroup
    ): BindableViewHolder<ListItem> = ContextThemeWrapper(parent.context, style)
        .let { themedContext -> LayoutInflater.from(themedContext) }
        .inflate(R.layout.list_item_pokemon, parent, false)
        .let { view -> ListItemPokemonBinding.bind(view) }
        .let { binding -> PokemonViewHolder(binding) { itemId -> _onClick.postValue(Event(itemId)) } }

    private fun titleHolder(
        @StyleRes style: Int,
        parent: ViewGroup
    ): BindableViewHolder<ListItem> = ContextThemeWrapper(parent.context, style)
        .let { themedContext -> LayoutInflater.from(themedContext) }
        .inflate(R.layout.list_item_title, parent, false)
        .let { view -> ListItemTitleBinding.bind(view) }
        .let { binding -> TitleViewHolder(binding) }
}