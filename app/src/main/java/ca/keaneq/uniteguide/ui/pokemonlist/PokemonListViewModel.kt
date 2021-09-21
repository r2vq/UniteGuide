package ca.keaneq.uniteguide.ui.pokemonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.keaneq.uniteguide.repo.PokemonRepository
import ca.keaneq.uniteguide.repo.model.Pokemon
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.pokemonToListItemPokemon
import kotlinx.coroutines.*

class PokemonListViewModel(
    private val repository: PokemonRepository
) : ViewModel() {
    private var _pokemonJob: Job? = null
    private val _data = MutableLiveData<List<ListItem>>()

    val data: LiveData<List<ListItem>> = _data

    fun getPokemon() {
        _pokemonJob = CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPokemon()
            withContext(Dispatchers.Main) {
                _data.postValue(
                    response.mapNotNull(Pokemon::pokemonToListItemPokemon)
                )
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        _pokemonJob?.cancel()
    }
}