package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.databinding.ListItemPokemonBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemPokemon
import com.bumptech.glide.Glide

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
        binding.tvPokemonName.setTextColor(
            binding.root.context.getColorFromAttr(
                pokemonItem?.textColor ?: R.attr.colorOnPrimary
            )
        )
        binding.cvPokemon.setCardBackgroundColor(
            binding.root.context.getColorFromAttr(
                pokemonItem?.backgroundColor ?: R.attr.colorPrimary
            )
        )
        pokemonItem
            ?.image
            ?.takeIf { image -> image.isNotBlank() }
            ?.let { image -> Glide.with(binding.root).load(image).into(binding.ivPokemonThumbnail) }
            ?: run { Glide.with(binding.root).clear(binding.ivPokemonThumbnail) }
    }
}