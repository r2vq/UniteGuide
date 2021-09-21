package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.databinding.ListItemPhotoBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemImage
import com.bumptech.glide.Glide

class ImageViewHolder(private val binding: ListItemPhotoBinding) :
    BindableViewHolder<ListItem>(binding.root) {

    override fun bind(item: ListItem) {
        val listItemImage = item as? ListItemImage
        listItemImage
            ?.imageUrl
            ?.let { imageUrl ->
                Glide.with(binding.root)
                    .load(imageUrl)
                    .into(binding.ivPokemonLarge)
            }
            ?: run {
                Glide.with(binding.root)
                    .clear(binding.ivPokemonLarge)
            }
    }
}