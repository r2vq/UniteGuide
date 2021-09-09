package ca.keaneq.uniteguide.ui.viewholder

import android.graphics.Color
import ca.keaneq.uniteguide.databinding.ListItemTitleBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemTitle

private const val DEFAULT_BACKGROUND_COLOR = "#000000"

class TitleViewHolder(private val binding: ListItemTitleBinding) :
    BindableViewHolder<ListItem>(binding.root) {
    override fun bind(item: ListItem) {
        val titleItem = item as? ListItemTitle

        binding.root.setBackgroundColor(
            titleItem?.backgroundColor ?: Color.parseColor(DEFAULT_BACKGROUND_COLOR)
        )

        binding.tvTitleText.text = titleItem?.text ?: ""
    }
}