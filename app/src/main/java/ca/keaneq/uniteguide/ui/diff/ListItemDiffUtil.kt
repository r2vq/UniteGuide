package ca.keaneq.uniteguide.ui.diff

import androidx.recyclerview.widget.DiffUtil
import ca.keaneq.uniteguide.ui.model.ListItem

class ListItemDiffUtil : DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem.areItemsTheSame(newItem)

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem.areContentsTheSame(newItem)
}