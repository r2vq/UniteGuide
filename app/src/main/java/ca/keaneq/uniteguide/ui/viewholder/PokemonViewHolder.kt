package ca.keaneq.uniteguide.ui.viewholder

import android.graphics.Color
import ca.keaneq.uniteguide.databinding.ListItemPokemonBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemPokemon
import com.bumptech.glide.Glide

private const val DEFAULT_BACKGROUND_COLOR = "#000000"

class PokemonViewHolder(
    private val binding: ListItemPokemonBinding,
    private val onPokemonClick: (String) -> Unit
) : BindableViewHolder<ListItem>(binding.root) {

    private var id: String? = null

    init {
        binding.root.setOnClickListener { id?.let(onPokemonClick) }
    }

    override fun bind(item: ListItem) {
        val pokemonItem = item as? ListItemPokemon
        id = pokemonItem?.id
        binding.tvPokemonName.text = pokemonItem?.name ?: ""
        binding.cvPokemon.setCardBackgroundColor(
            pokemonItem?.backgroundColor ?: Color.parseColor(DEFAULT_BACKGROUND_COLOR)
        )
        pokemonItem
            ?.image
            ?.takeIf { image -> image.isNotBlank() }
            ?.let { image -> Glide.with(binding.root).load(image).into(binding.ivPokemonThumbnail) }
            ?: run { Glide.with(binding.root).clear(binding.ivPokemonThumbnail) }
    }
}