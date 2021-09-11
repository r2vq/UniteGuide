package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.databinding.ListItemEmptyBinding
import ca.keaneq.uniteguide.ui.model.ListItem

class EmptyViewHolder(
    private val binding: ListItemEmptyBinding
) : BindableViewHolder<ListItem>(binding.root) {
    override fun bind(item: ListItem) {
        binding.root.height
    }
}