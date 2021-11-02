package ca.keaneq.uniteguide.presentation.pokemondetail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.keaneq.domain.model.Resource
import ca.keaneq.domain.usecase.GetPokemonUseCase
import ca.keaneq.uniteguide.presentation.model.toPokemonItem
import ca.keaneq.uniteguide.presentation.navigation.ARG_POKEMON_ID
import ca.keaneq.uniteguide.presentation.pokemondetail.model.PokemonDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = mutableStateOf(PokemonDetailState())
    val state: State<PokemonDetailState> = _state

    init {
        savedStateHandle.get<String>(ARG_POKEMON_ID)?.let { pokemonId ->
            getPokemonDetails(pokemonId)
        }
    }

    private fun getPokemonDetails(pokemonId: String) = getPokemonUseCase(pokemonId)
        .onEach { result ->
            when (result) {
                is Resource.Success -> _state.value = PokemonDetailState(
                    pokemon = result.data?.toPokemonItem()
                )
                is Resource.Loading -> _state.value = PokemonDetailState(
                    isLoading = true
                )
                is Resource.Error -> _state.value = PokemonDetailState(
                    error = result.message ?: "Error message missing."
                )
            }
        }.launchIn(viewModelScope)
}