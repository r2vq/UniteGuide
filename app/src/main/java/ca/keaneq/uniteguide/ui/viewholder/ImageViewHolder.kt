package ca.keaneq.uniteguide.ui.viewholder

import android.graphics.Color
import ca.keaneq.uniteguide.databinding.ListItemPhotoBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemImage
import com.bumptech.glide.Glide

private const val DEFAULT_BACKGROUND_COLOR = "#000000"

class ImageViewHolder(private val binding: ListItemPhotoBinding) :
    BindableViewHolder<ListItem>(binding.root) {

    override fun bind(item: ListItem) {
        val listItemImage = item as? ListItemImage

        listItemImage
            ?.backgroundColor
            ?.let { color ->
                binding.vwBackgroundTop
                    .setBackgroundColor(color)
            }
            ?: run {
                binding.vwBackgroundTop
                    .setBackgroundColor(Color.parseColor(DEFAULT_BACKGROUND_COLOR))
            }

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