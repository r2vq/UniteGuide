package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.databinding.ListItemSubtitleBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemResSubtitle

class SubtitleViewHolder(
    private val binding: ListItemSubtitleBinding
) : BindableViewHolder<ListItem>(binding.root) {
    override fun bind(item: ListItem) {
        when {
            item is ListItemResSubtitle -> {
                binding.tvSubtitle.text = item.getText(binding.root.context)
            }
            else -> {
                binding.tvSubtitle.text = ""
            }
        }
    }
}