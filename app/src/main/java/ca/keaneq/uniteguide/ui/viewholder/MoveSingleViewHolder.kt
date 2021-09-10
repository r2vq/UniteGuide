package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.databinding.ListItemMoveSingleBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemMoveSingle
import com.bumptech.glide.Glide

class MoveSingleViewHolder(
    private val binding: ListItemMoveSingleBinding
) : BindableViewHolder<ListItem>(binding.root) {
    override fun bind(item: ListItem) {
        val moveItem = item as? ListItemMoveSingle
        binding.tvMoveName.text = moveItem?.name ?: ""
        binding.tvMoveDescription.text = moveItem?.description ?: ""
        moveItem?.image
            ?.let { image ->
                Glide.with(binding.root)
                    .load(image)
                    .into(binding.ivMoveIcon)
            }
            ?: run {
                Glide.with(binding.root)
                    .clear(binding.ivMoveIcon)
            }
    }
}