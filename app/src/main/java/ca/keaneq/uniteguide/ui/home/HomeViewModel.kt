package ca.keaneq.uniteguide.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.keaneq.uniteguide.api.PokeApi
import ca.keaneq.uniteguide.api.model.PokemonRootResponse
import kotlinx.coroutines.*

class HomeViewModel(
    private val api: PokeApi
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    private var _pokemonJob: Job? = null
    private val _pokemon = MutableLiveData<PokemonRootResponse>()

    val text: LiveData<String> = _text
    val pokemon: LiveData<PokemonRootResponse> = _pokemon

    fun getPokemon() {
        _pokemonJob = CoroutineScope(Dispatchers.IO).launch {
            val response = api.getPokemon()
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