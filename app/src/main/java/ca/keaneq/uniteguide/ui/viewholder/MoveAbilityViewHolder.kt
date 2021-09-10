package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.databinding.ListItemMoveAbilityBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemMoveAbility
import com.bumptech.glide.Glide

class MoveAbilityViewHolder(
    private val binding: ListItemMoveAbilityBinding,
    private val onItemClick: (String) -> Unit,
) : BindableViewHolder<ListItem>(binding.root) {

    private var id: String? = null

    init {
        binding.root.setOnClickListener {
            id?.let(onItemClick)
        }
    }

    override fun bind(item: ListItem) {
        val ability = item as? ListItemMoveAbility

        id = ability?.id

        binding.tvMoveName.text = ability?.name ?: ""
        binding.tvMoveDescription.text = ability?.description ?: ""
        ability?.image
            ?.let { image -> Glide.with(binding.root).load(image).into(binding.ivMoveIcon) }
            ?: run { Glide.with(binding.root).clear(binding.ivMoveIcon) }
    }
}