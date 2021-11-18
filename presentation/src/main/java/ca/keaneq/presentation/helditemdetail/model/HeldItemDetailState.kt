package ca.keaneq.presentation.helditemdetail.model

import ca.keaneq.presentation.helditemdetail.component.HeldItemDetailComponent

data class HeldItemDetailState(
    val isLoading: Boolean = false,
    val pageItems: List<HeldItemDetailComponent> = emptyList(),
    val error: String = "",
)
