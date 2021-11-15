package ca.keaneq.presentation.helditemlist.model

import ca.keaneq.domain.model.HeldItem

data class HeldItemListState(
    val isLoading: Boolean = false,
    val heldItems: List<HeldItem> = emptyList(),
    val error: String = "",
)