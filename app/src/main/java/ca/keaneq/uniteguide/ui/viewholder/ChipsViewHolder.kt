package ca.keaneq.uniteguide.ui.viewholder

import android.content.res.ColorStateList
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.databinding.ListItemChipsBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemChips

class ChipsViewHolder(
    private val binding: ListItemChipsBinding
) : BindableViewHolder<ListItem>(binding.root) {
    override fun bind(item: ListItem) {
        val chipItem = item as? ListItemChips

        binding.leftChip.chipBackgroundColor = ColorStateList.valueOf(
            binding.root.context.getColorFromAttr(
                chipItem?.leftChip?.backgroundColor ?: R.attr.colorPrimary
            )
        )
        binding.leftChip.setTextColor(
            binding.root.context.getColorFromAttr(
                chipItem?.leftChip?.textColor ?: R.attr.colorOnPrimary
            )
        )
        chipItem
            ?.leftChip
            ?.text
            ?.let { text -> binding.leftChip.setText(text) }
            ?: run { binding.leftChip.text = "" }

        binding.rightChip.chipBackgroundColor = ColorStateList.valueOf(
            binding.root.context.getColorFromAttr(
                chipItem?.rightChip?.backgroundColor ?: R.attr.colorPrimary
            )
        )
        binding.rightChip.setTextColor(
            binding.root.context.getColorFromAttr(
                chipItem?.rightChip?.textColor ?: R.attr.colorOnPrimary
            )
        )
        chipItem
            ?.rightChip
            ?.text
            ?.let { text -> binding.rightChip.setText(text) }
            ?: run { binding.rightChip.text = "" }
    }
}