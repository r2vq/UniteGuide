package ca.keaneq.uniteguide.ui.viewholder

import android.view.View
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.databinding.ListItemEvolutionsBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemEvolutions
import com.bumptech.glide.Glide

class EvolutionsViewHolder(
    private val binding: ListItemEvolutionsBinding
) : BindableViewHolder<ListItem>(binding.root) {
    override fun bind(item: ListItem) {
        val evolutionItem = item as? ListItemEvolutions
        val glide = Glide.with(binding.root)
        val context = binding.root.context

        evolutionItem?.species?.getOrNull(0)?.let { species ->
            glide.load(species.image).into(binding.ivEvolution0)
        } ?: run {
            glide.clear(binding.ivEvolution0)
        }

        evolutionItem?.species?.getOrNull(1)?.let { species ->
            binding.ivEvolution1.visibility = View.VISIBLE
            binding.tvEvolvesAt1.text = context.getString(
                R.string.evolves_at,
                species.level
            )
            binding.tvEvolvesAt1.visibility = View.VISIBLE
            glide.load(species.image).into(binding.ivEvolution1)
        } ?: run {
            binding.ivEvolution1.visibility = View.GONE
            binding.tvEvolvesAt1.visibility = View.GONE
            binding.tvEvolvesAt1.text = ""
            glide.clear(binding.ivEvolution1)
        }

        evolutionItem?.species?.getOrNull(2)?.let { species ->
            binding.ivEvolution2.visibility = View.VISIBLE
            binding.tvEvolvesAt2.text = context.getString(
                R.string.evolves_at,
                species.level
            )
            binding.tvEvolvesAt2.visibility = View.VISIBLE
            glide.load(species.image).into(binding.ivEvolution2)
        } ?: run {
            binding.ivEvolution2.visibility = View.GONE
            binding.tvEvolvesAt2.visibility = View.GONE
            binding.tvEvolvesAt2.text = ""
            glide.clear(binding.ivEvolution2)
        }
    }
}