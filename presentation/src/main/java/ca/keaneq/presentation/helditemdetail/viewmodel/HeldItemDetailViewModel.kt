package ca.keaneq.presentation.helditemdetail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.keaneq.domain.model.*
import ca.keaneq.domain.usecase.GetHeldItemUseCase
import ca.keaneq.presentation.helditemdetail.model.*
import ca.keaneq.presentation.helditemdetail.model.HeldItemDetailEvent.ClickStat
import ca.keaneq.presentation.helditemdetail.model.HeldItemDetailEvent.ClickUpgrade
import ca.keaneq.presentation.main.navigation.ARG_HELD_ITEM_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HeldItemDetailViewModel @Inject constructor(
    private val getHeldItemUseCase: GetHeldItemUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = mutableStateOf(HeldItemDetailState())
    val state: State<HeldItemDetailState> = _state

    init {
        savedStateHandle.get<String>(ARG_HELD_ITEM_ID)
            ?.let { heldItemId ->
                getHeldItemDetails(heldItemId)
            }
            ?.launchIn(viewModelScope)
    }

    fun onEvent(event: HeldItemDetailEvent) = when (event) {
        is ClickUpgrade -> updateUpgrades(event.upgrade)
        is ClickStat -> updateStat(event.stat)
    }

    private fun getHeldItemDetails(heldItemId: String) = getHeldItemUseCase(heldItemId)
        .onEach { result ->
            when (result) {
                is Resource.Success -> _state.value = HeldItemDetailState(
                    heldItem = result.data?.toState()
                )
                is Resource.Loading -> _state.value = HeldItemDetailState(
                    isLoading = true
                )
                is Resource.Error -> _state.value = HeldItemDetailState(
                    error = result.message ?: "Error message missing."
                )
            }
        }

    private fun updateStat(stat: HeldItemStatState) {
        _state.value = _state.value.copy(
            heldItem = _state.value.heldItem?.let { state ->
                state.copy(
                    stats = state.stats.map {
                        it.takeUnless { it == stat } ?: it.copy(
                            name = it.name,
                            isClicked = !it.isClicked,
                        )
                    }
                )
            }
        )
    }

    private fun updateUpgrades(upgrade: HeldItemUpgradeState) {
        _state.value = _state.value.copy(
            heldItem = _state.value.heldItem?.let { state ->
                state.copy(
                    upgrades = state.upgrades.map {
                        if (it == upgrade) {
                            it.copy(
                                isClicked = true
                            )
                        } else {
                            it.copy(
                                isClicked = false
                            )
                        }
                    }
                )
            }
        )
    }
}

private fun HeldItem.toState(): HeldItemState = HeldItemState(
    name = name,
    image = image,
    stats = stats.map { stat -> stat.toState() },
    upgrades = upgrades.mapIndexed { i, upgrade ->
        upgrade.toState(isClicked = i == 0)
    }
)

private fun HeldItemStat.toState() = HeldItemStatState(
    name = name,
    details = detail.map { it.toState() },
    isClicked = false,
)

private fun HeldItemStatDetail.toState() = HeldItemStatDetailState(
    level = level,
    description = description,
)

private fun HeldItemUpgrade.toState(
    isClicked: Boolean,
) = HeldItemUpgradeState(
    description = description,
    image = image,
    isClicked = isClicked,
)

