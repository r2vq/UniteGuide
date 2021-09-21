package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.databinding.ListItemTitleBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemTitle

class TitleViewHolder(private val binding: ListItemTitleBinding) :
    BindableViewHolder<ListItem>(binding.root) {
    override fun bind(item: ListItem) {
        val titleItem = item as? ListItemTitle
        binding.tvTitleText.text = titleItem?.text ?: ""
    }
}