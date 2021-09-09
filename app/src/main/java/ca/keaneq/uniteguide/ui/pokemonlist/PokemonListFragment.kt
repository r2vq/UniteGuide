package ca.keaneq.uniteguide.ui.pokemonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.databinding.FragmentHomeBinding
import ca.keaneq.uniteguide.ui.adapter.ContentAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListFragment : Fragment() {

    private val pokemonListViewModel: PokemonListViewModel by viewModel()
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

        val rvPokemon: RecyclerView = binding.rvPokemon
        rvPokemon.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvPokemon.adapter = listAdapter

        pokemonListViewModel.data.observe(viewLifecycleOwner, listAdapter::submitList)
        pokemonListViewModel.getPokemon()

        listAdapter.onClick.observe(viewLifecycleOwner) { pokemonId ->
            pokemonId
                .getContentIfNotHandled()
                ?.let { id ->
                    val detailBundle = bundleOf("pokemonId" to id)
                    findNavController().navigate(R.id.navigation_pokemon_detail, detailBundle)
                }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}