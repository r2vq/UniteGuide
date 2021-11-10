package ca.keaneq.presentation.pokemondetail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.keaneq.domain.model.Resource
import ca.keaneq.domain.usecase.GetPokemonUseCase
import ca.keaneq.presentation.navigation.ARG_POKEMON_ID
import ca.keaneq.presentation.pokemondetail.model.PokemonState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = mutableStateOf(PokemonState())
    val state: State<PokemonState> = _state

    init {
        savedStateHandle.get<String>(ARG_POKEMON_ID)?.let { pokemonId ->
            getPokemonDetails(pokemonId)
        }
    }

    private fun getPokemonDetails(pokemonId: String) = getPokemonUseCase(pokemonId)
        .onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PokemonState(
                        pokemon = result.data
                    )
                }
                is Resource.Loading -> {
                    _state.value = PokemonState(
                        isLoading = true
                    )
                }
                is Resource.Error -> {
                    _state.value = PokemonState(
                        error = result.message ?: "Error message missing."
                    )
                }
            }
        }.launchIn(viewModelScope)
}