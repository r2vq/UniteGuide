package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.databinding.ListItemHomeBinding
import ca.keaneq.uniteguide.ui.getColorFromAttr
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemHome
import com.bumptech.glide.Glide

class HomeItemViewHolder(
    private val binding: ListItemHomeBinding,
    private val onClick: (String) -> Unit,
) : BindableViewHolder<ListItem>(binding.root) {

    private var id: String? = null

    init {
        binding.root.setOnClickListener {
            id?.let(onClick)
        }
    }

    override fun bind(item: ListItem) {
        val homeItem = item as? ListItemHome
        val root = binding.root

        id = homeItem?.id

        homeItem?.color
            ?.let { color -> binding.cvHomeItem.strokeColor = root.context.getColorFromAttr(color) }
            ?: run {
                binding.cvHomeItem.strokeColor =
                    root.context.getColorFromAttr(R.attr.colorOnBackground)
            }

        homeItem?.image
            ?.let { image -> Glide.with(root).load(image).into(binding.ivItemIcon) }
            ?: run { Glide.with(root).clear(binding.ivItemIcon) }

        binding.tvItemName.text = homeItem?.title ?: ""
    }
}
