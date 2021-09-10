package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.databinding.ListItemMoveSingleBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemMoveSingle
import com.bumptech.glide.Glide

class MoveSingleViewHolder(
    private val binding: ListItemMoveSingleBinding,
    private val onClick: (String) -> Unit,
) : BindableViewHolder<ListItem>(binding.root) {

    private var id: String? = null

    init {
        binding.root.setOnClickListener {
            id?.let(onClick)
        }
    }

    override fun bind(item: ListItem) {
        val moveItem = item as? ListItemMoveSingle
        id = moveItem?.id
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