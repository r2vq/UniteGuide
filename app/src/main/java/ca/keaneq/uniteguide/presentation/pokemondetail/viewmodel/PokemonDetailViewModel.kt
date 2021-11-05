package ca.keaneq.uniteguide.presentation.pokemondetail.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.keaneq.domain.model.Resource
import ca.keaneq.domain.usecase.GetPokemonUseCase
import ca.keaneq.uniteguide.lifecycle.Event
import ca.keaneq.uniteguide.presentation.model.toPokemonItem
import ca.keaneq.uniteguide.presentation.navigation.ARG_POKEMON_ID
import ca.keaneq.uniteguide.presentation.pokemondetail.model.PokemonDetailState
import ca.keaneq.uniteguide.presentation.pokemondetail.model.SheetData
import ca.keaneq.uniteguide.presentation.pokemondetail.model.toSheetData
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
    private val _sheet: MutableState<Event<SheetData>?> = mutableStateOf(null)
    val sheet: State<Event<SheetData>?> = _sheet
    private val moves: MutableList<SheetData> = mutableListOf()

    init {
        savedStateHandle.get<String>(ARG_POKEMON_ID)?.let { pokemonId ->
            getPokemonDetails(pokemonId)
        }
    }

    fun onItemClick(position: Int) {
        moves.getOrNull(position)
            ?.let { event -> _sheet.value = Event(event) }
    }

    private fun getPokemonDetails(pokemonId: String) = getPokemonUseCase(pokemonId)
        .onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PokemonDetailState(
                        pokemon = result.data?.toPokemonItem()?.also { pokemon ->
                            moves.clear()
                            pokemon.moves.forEach { move ->
                                moves.add(move.toSheetData())
                            }
                        }
                    )
                }
                is Resource.Loading -> _state.value = PokemonDetailState(
                    isLoading = true
                )
                is Resource.Error -> _state.value = PokemonDetailState(
                    error = result.message ?: "Error message missing."
                )
            }
        }.launchIn(viewModelScope)
}