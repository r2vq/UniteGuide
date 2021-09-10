package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.R
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
        binding.tvCooldown.text = ability?.cooldown ?: ""
        binding.tvMoveDescription.text = ability?.description ?: ""
        ability?.upgrade?.let { upgrade ->
            binding.tvUpgrade.text = binding.root.context.getString(R.string.move_upgrade, upgrade)
        } ?: run {
            binding.tvUpgrade.text = ""
        }
        ability?.image
            ?.let { image -> Glide.with(binding.root).load(image).into(binding.ivMoveIcon) }
            ?: run { Glide.with(binding.root).clear(binding.ivMoveIcon) }

        binding.tvUpgrade1Name.text = ability?.upgrade1Name
        binding.tvUpgrade1Cooldown.text = ability?.upgrade1Cooldown
        binding.tvUpgrade1Description.text = ability?.upgrade1Description
        ability?.upgrade1Image
            ?.let { image -> Glide.with(binding.root).load(image).into(binding.ivUpgrade1Icon) }
            ?: run { Glide.with(binding.root).clear(binding.ivUpgrade1Icon) }

        binding.tvUpgrade2Name.text = ability?.upgrade2Name
        binding.tvUpgrade2Cooldown.text = ability?.upgrade2Cooldown
        binding.tvUpgrade2Description.text = ability?.upgrade2Description
        ability?.upgrade2Image
            ?.let { image -> Glide.with(binding.root).load(image).into(binding.ivUpgrade2Icon) }
            ?: run { Glide.with(binding.root).clear(binding.ivUpgrade2Icon) }
    }
}