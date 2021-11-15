package ca.keaneq.presentation.helditemlist.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.keaneq.domain.model.Resource
import ca.keaneq.domain.usecase.GetHeldItemListUseCase
import ca.keaneq.presentation.helditemlist.model.HeldItemListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HeldItemListViewModel @Inject constructor(
    private val getHeldItemListUseCase: GetHeldItemListUseCase
) : ViewModel() {
    private val _state = mutableStateOf(HeldItemListState())
    val state: State<HeldItemListState> = _state

    init {
        getHeldItemList()
    }

    private fun getHeldItemList() = getHeldItemListUseCase().onEach { result ->
        when (result) {
            is Resource.Success -> _state.value = HeldItemListState(
                heldItems = result.data ?: emptyList()
            )
            is Resource.Loading -> _state.value = HeldItemListState(
                isLoading = true
            )
            is Resource.Error -> _state.value = HeldItemListState(
                error = result.message ?: "Error message missing."
            )
        }
    }.launchIn(viewModelScope)
}