package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.databinding.ListItemMoveSingleCompressedBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemMoveSingleCompressed
import com.bumptech.glide.Glide

class MoveSingleCompressedViewHolder(
    private val binding: ListItemMoveSingleCompressedBinding,
    private val onClick: (String) -> Unit,
) : BindableViewHolder<ListItem>(binding.root) {

    private var id: String? = null

    init {
        binding.root.setOnClickListener {
            id?.let(onClick)
        }
    }

    override fun bind(item: ListItem) {
        val moveItem = item as? ListItemMoveSingleCompressed
        id = moveItem?.id
        binding.tvMoveName.text = moveItem?.name ?: ""
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