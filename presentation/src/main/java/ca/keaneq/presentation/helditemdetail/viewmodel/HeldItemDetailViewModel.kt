package ca.keaneq.presentation.helditemdetail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.keaneq.domain.model.HeldItem
import ca.keaneq.domain.model.Resource
import ca.keaneq.domain.usecase.GetHeldItemUseCase
import ca.keaneq.presentation.helditemdetail.component.*
import ca.keaneq.presentation.helditemdetail.model.HeldItemDetailState
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

    private fun getHeldItemDetails(heldItemId: String) = getHeldItemUseCase(heldItemId)
        .onEach { result ->
            when (result) {
                is Resource.Success -> _state.value = HeldItemDetailState(
                    pageItems = result.data?.toState() ?: emptyList()
                )
                is Resource.Loading -> _state.value = HeldItemDetailState(
                    isLoading = true
                )
                is Resource.Error -> _state.value = HeldItemDetailState(
                    error = result.message ?: "Error message missing."
                )
            }
        }
}

private fun HeldItem.toState(): List<HeldItemDetailComponent> {
    return mutableListOf<HeldItemDetailComponent>()
        .apply {
            add(HeldItemDetailName(name = name))
            add(HeldItemDetailImage(url = image))
            upgrades.forEach { upgrade ->
                add(
                    HeldItemDetailUpgrade(
                        level = upgrade.level,
                        description = upgrade.description,
                        image = image, // todo replace this with upgrade.image
                    )
                )
            }
            stats.forEach { stat ->
                add(
                    HeldItemDetailStat(
                        name = stat.name,
                        details = stat.detail.map { detail ->
                            HeldItemStatDetail(
                                level = detail.level,
                                description = detail.description,
                            )
                        }
                    )
                )
            }
        }
        .toList()
}

