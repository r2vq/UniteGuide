package ca.keaneq.uniteguide.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ca.keaneq.uniteguide.BuildConfig
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.databinding.FragmentAboutBinding
import ca.keaneq.uniteguide.ui.adapter.ContentAdapter
import ca.keaneq.uniteguide.ui.model.ListItemAbout
import org.koin.android.ext.android.inject

class AboutFragment : Fragment() {

    private val listAdapter: ContentAdapter by inject()
    private var _binding: FragmentAboutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root = binding.root

        val rvAbout = binding.rvAbout
        rvAbout.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvAbout.adapter = listAdapter

        listAdapter.submitList(
            listOf(
                ListItemAbout(
                    id = "Version",
                    title = getString(R.string.about_version_title),
                    subtitle = "v${BuildConfig.VERSION_NAME}",
                    body = null,
                ),
                ListItemAbout(
                    id = "Disclaimer",
                    title = getString(R.string.about_disclaimer_title),
                    subtitle = null,
                    body = getString(R.string.about_disclaimer_body),
                )
            )
        )

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}