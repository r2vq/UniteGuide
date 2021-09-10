package ca.keaneq.uniteguide.ui.pokemondetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.lifecycle.Event
import ca.keaneq.uniteguide.repo.PokemonRepository
import ca.keaneq.uniteguide.ui.*
import ca.keaneq.uniteguide.ui.model.*
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
                response?.run {
                    emptySequence<ListItem>()
                        .plus(pokemonToTitle("title"))
                        .plus(pokemonToImage("image"))
                        .plus(pokemonToChips("chips"))
                        .plus(pokemonToFacts("facts"))
                        .plus(
                            ListItemResSubtitle("evolution-subtitle", R.string.header_evolutions)
                        )
                        .plus(pokemonToEvolution("evolution"))
                        .plus(
                            ListItemResSubtitle("moveset-subtitle", R.string.header_moveset)
                        )
                        .plus(
                            moveset.mapIndexed { index, moveset ->
                                moveset.pokemonToMoveAbility("moveset-basic-$index")
                            }
                        )
                        .plus(pokemonToUnite("moveset-unite"))
                        .plus(pokemonToPassive("moveset-passive"))
                        .plus(pokemonToBasic("moveset-basic"))
                        .toList()
                }
                    ?.let(_data::postValue)
            }
        }
    }

    fun onItemClick(idEvent: Event<String>) {
        val id = idEvent.getContentIfNotHandled()
        _data.value?.let { items ->
            items.map { listItem ->
                when {
                    listItem is ListItemMoveAbilityCompressed && listItem.id == id -> listItem.expand()
                    listItem is ListItemMoveAbility && listItem.id == id -> listItem.compress()
                    listItem is ListItemMoveSingleCompressed && listItem.id == id -> listItem.expand()
                    listItem is ListItemMoveSingle && listItem.id == id -> listItem.compress()
                    else -> listItem
                }
            }
        }?.let { list -> _data.postValue(list) }
    }

    override fun onCleared() {
        super.onCleared()
        _pokemonJob?.cancel()
    }
}