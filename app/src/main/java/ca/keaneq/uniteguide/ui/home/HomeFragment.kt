package ca.keaneq.uniteguide.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.keaneq.uniteguide.databinding.FragmentHomeBinding
import ca.keaneq.uniteguide.ui.adapter.ContentAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val listAdapter: ContentAdapter by inject()
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val rvContent: RecyclerView = binding.rvContent
        rvContent.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvContent.adapter = listAdapter

        listAdapter.onClick.observe(viewLifecycleOwner) { id ->
            homeViewModel.onClick(id)
        }

        homeViewModel.items.observe(viewLifecycleOwner) { content ->
            listAdapter.submitList(content)
        }

        homeViewModel.navigate.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()
                ?.let { id -> findNavController().navigate(id) }
        }

        homeViewModel.loadItems()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}