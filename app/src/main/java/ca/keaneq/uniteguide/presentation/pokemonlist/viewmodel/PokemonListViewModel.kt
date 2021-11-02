package ca.keaneq.uniteguide.presentation.pokemonlist.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.keaneq.domain.model.Pokemon
import ca.keaneq.domain.model.Resource
import ca.keaneq.domain.usecase.GetPokemonListUseCase
import ca.keaneq.uniteguide.presentation.model.toPokemonItem
import ca.keaneq.uniteguide.presentation.pokemonlist.model.PokemonListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {
    private val _state = mutableStateOf(PokemonListState())
    val state: State<PokemonListState> = _state

    init {
        getPokemonList()
    }

    private fun getPokemonList() = getPokemonListUseCase().onEach { result ->
        when (result) {
            is Resource.Success -> _state.value = PokemonListState(
                pokemon = result.data?.map(Pokemon::toPokemonItem) ?: emptyList()
            )
            is Resource.Loading -> _state.value = PokemonListState(
                isLoading = true
            )
            is Resource.Error -> _state.value = PokemonListState(
                error = result.message ?: "Error message missing."
            )
        }
    }.launchIn(viewModelScope)
}