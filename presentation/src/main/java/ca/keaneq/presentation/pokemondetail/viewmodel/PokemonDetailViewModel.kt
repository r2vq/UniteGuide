package ca.keaneq.presentation.pokemondetail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.keaneq.domain.model.Pokemon
import ca.keaneq.domain.model.Resource
import ca.keaneq.domain.usecase.GetPokemonUseCase
import ca.keaneq.presentation.navigation.ARG_POKEMON_ID
import ca.keaneq.presentation.pokemondetail.model.MoveState
import ca.keaneq.presentation.pokemondetail.model.MoveType
import ca.keaneq.presentation.pokemondetail.model.PokemonDetailState
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
    private val _state = mutableStateOf(PokemonDetailState())
    val state: State<PokemonDetailState> = _state

    init {
        savedStateHandle.get<String>(ARG_POKEMON_ID)?.let { pokemonId ->
            getPokemonDetails(pokemonId)
        }
    }

    fun onMoveClick(id: Int) {
        state.value.pokemon?.let { pokemonState ->
            _state.value = PokemonDetailState(
                pokemon = pokemonState.copy(
                    moves = pokemonState.moves.map { move ->
                        move
                            .takeUnless { it.id == id }
                            ?: move.copy(isExpanded = !move.isExpanded)
                    }
                ),
            )
        }
    }

    private fun getPokemonDetails(pokemonId: String) = getPokemonUseCase(pokemonId)
        .onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PokemonDetailState(
                        pokemon = result.data?.let { data ->
                            PokemonState(
                                pokemon = data,
                                moves = data.toMoves()
                            )
                        }
                    )
                }
                is Resource.Loading -> {
                    _state.value = PokemonDetailState(
                        isLoading = true
                    )
                }
                is Resource.Error -> {
                    _state.value = PokemonDetailState(
                        error = result.message ?: "Error message missing."
                    )
                }
            }
        }.launchIn(viewModelScope)
}

private fun Pokemon.toMoves(): List<MoveState> = mutableListOf<MoveState>()
    .apply {
        var i = 0
        add(
            MoveState(
                id = i++,
                name = passive.name,
                description = passive.description,
                image = passive.image,
                moveType = MoveType.SINGLE,
            )
        )
        add(
            MoveState(
                id = i++,
                name = basic.name,
                description = basic.description,
                image = basic.image,
                moveType = MoveType.SINGLE,
            )
        )
        moveset.forEach { moveset ->
            add(
                MoveState(
                    id = i++,
                    name = moveset.name,
                    description = moveset.description,
                    image = moveset.image,
                    cooldown = moveset.cooldown,
                    upgrade = moveset.upgrade,
                    moveType = MoveType.BASIC_ABILITY,
                )
            )
            val upgradesSize = moveset.upgrades.size - 1
            moveset.upgrades.forEachIndexed { j, move ->
                add(
                    MoveState(
                        id = i++,
                        name = move.name,
                        description = move.description,
                        image = move.image,
                        cooldown = move.cooldown,
                        moveType = if (j == upgradesSize) MoveType.UPGRADE_ABILITY_END else MoveType.UPGRADE_ABILITY,
                    )
                )
            }
        }
        add(
            MoveState(
                id = i,
                name = unite.name,
                description = unite.description,
                image = unite.image,
                moveType = MoveType.SINGLE,
            )
        )
    }
    .toList()
