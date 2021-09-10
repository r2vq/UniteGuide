package ca.keaneq.uniteguide.ui.pokemondetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.repo.PokemonRepository
import ca.keaneq.uniteguide.ui.*
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemResSubtitle
import kotlinx.coroutines.*

class PokemonDetailViewModel(
    private val repository: PokemonRepository
) : ViewModel() {
    private var _pokemonJob: Job? = null
    private val _data = MutableLiveData<List<ListItem>>()

    val data: LiveData<List<ListItem>> = _data

    fun getPokemon(id: String) {
        _pokemonJob = CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPokemon(id)
            withContext(Dispatchers.Main) {
                response
                    ?.run {
                        listOf(
                            pokemonToTitle("title"),
                            pokemonToImage("image"),
                            pokemonToChips("chips"),
                            pokemonToFacts("facts"),
                            ListItemResSubtitle("evolution-subtitle", R.string.header_evolutions),
                            pokemonToEvolution("evolution"),
                            ListItemResSubtitle("moveset-subtitle", R.string.header_moveset),
                            pokemonToUnite("moveset-unite"),
                            pokemonToPassive("moveset-passive"),
                        )
                    }
                    ?.let(_data::postValue)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        _pokemonJob?.cancel()
    }
}