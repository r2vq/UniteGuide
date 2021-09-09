package ca.keaneq.uniteguide.ui.viewholder

import android.content.res.ColorStateList
import android.graphics.Color
import ca.keaneq.uniteguide.databinding.ListItemChipsBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemChips

private const val DEFAULT_BACKGROUND_COLOR = "#000000"

class ChipsViewHolder(
    private val binding: ListItemChipsBinding
) : BindableViewHolder<ListItem>(binding.root) {
    override fun bind(item: ListItem) {
        val chipItem = item as? ListItemChips

        binding.leftChip.chipBackgroundColor = ColorStateList.valueOf(
            chipItem?.leftChip?.backgroundColor
                ?: Color.parseColor(DEFAULT_BACKGROUND_COLOR)
        )
        chipItem
            ?.leftChip
            ?.text
            ?.let { text -> binding.leftChip.setText(text) }
            ?: run { binding.leftChip.text = "" }

        binding.rightChip.chipBackgroundColor = ColorStateList.valueOf(
            chipItem?.rightChip?.backgroundColor
                ?: Color.parseColor(DEFAULT_BACKGROUND_COLOR)
        )
        chipItem
            ?.rightChip
            ?.text
            ?.let { text -> binding.rightChip.setText(text) }
            ?: run { binding.rightChip.text = "" }
    }
}