package ca.keaneq.uniteguide.ui.viewholder

import ca.keaneq.uniteguide.databinding.ListItemFactsBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemFacts

class FactsViewHolder(
    private val binding: ListItemFactsBinding
) : BindableViewHolder<ListItem>(binding.root) {
    override fun bind(item: ListItem) {
        val factItem = item as? ListItemFacts

        factItem?.leftFact
            ?.let { fact -> binding.tvFactLeft.setText(fact) }
            ?: run { binding.tvFactLeft.text = "" }

        factItem?.centerFact
            ?.let { fact -> binding.tvFactCenter.setText(fact) }
            ?: run { binding.tvFactCenter.text = "" }

        factItem?.rightFact
            ?.let { fact -> binding.tvFactRight.setText(fact) }
            ?: run { binding.tvFactRight.text = "" }
    }
}