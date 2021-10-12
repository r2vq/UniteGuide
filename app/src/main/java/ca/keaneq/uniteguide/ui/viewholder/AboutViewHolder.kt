package ca.keaneq.uniteguide.ui.viewholder

import android.view.View
import ca.keaneq.uniteguide.databinding.ListItemAboutBinding
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemAbout

class AboutViewHolder(private val binding: ListItemAboutBinding) :
    BindableViewHolder<ListItem>(binding.root) {

    override fun bind(item: ListItem) {
        val aboutItem = item as? ListItemAbout

        val tvAboutTitle = binding.tvAboutTitle
        aboutItem?.title?.let { title ->
            tvAboutTitle.text = title
            tvAboutTitle.visibility = View.VISIBLE
        } ?: run {
            tvAboutTitle.text = ""
            tvAboutTitle.visibility = View.GONE
        }

        val tvAboutSubtitle = binding.tvAboutSubtitle
        aboutItem?.subtitle?.let { subtitle ->
            tvAboutSubtitle.text = subtitle
            tvAboutSubtitle.visibility = View.VISIBLE
        } ?: run {
            tvAboutSubtitle.text = ""
            tvAboutSubtitle.visibility = View.GONE
        }

        val tvAboutBody = binding.tvAboutBody
        aboutItem?.body?.let { body ->
            tvAboutBody.text = body
            tvAboutBody.visibility = View.VISIBLE
        } ?: run {
            tvAboutBody.text = ""
            tvAboutBody.visibility = View.GONE
        }
    }
}