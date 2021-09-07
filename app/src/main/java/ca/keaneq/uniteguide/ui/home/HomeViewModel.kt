package ca.keaneq.uniteguide.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.keaneq.uniteguide.repo.PokemonRepository
import ca.keaneq.uniteguide.repo.model.Pokemon
import kotlinx.coroutines.*

class HomeViewModel(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    private var _pokemonJob: Job? = null
    private val _pokemon = MutableLiveData<List<Pokemon>>()

    val text: LiveData<String> = _text
    val pokemon: LiveData<List<Pokemon>> = _pokemon

    fun getPokemon() {
        _pokemonJob = CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPokemon()
            withContext(Dispatchers.Main) {
                _pokemon.postValue(response)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        _pokemonJob?.cancel()
    }
}