package ca.keaneq.presentation.helditemdetail.model

data class HeldItemDetailState(
    val isLoading: Boolean = false,
    val heldItem: HeldItemState? = null,
    val error: String = "",
)

data class HeldItemState(
    val name: String,
    val image: String,
    val stats: List<HeldItemStatState>,
    val upgrades: List<HeldItemUpgradeState>,
)

data class HeldItemStatState(
    val name: String,
    val details: List<HeldItemStatDetailState>,
    val isClicked: Boolean,
)

data class HeldItemStatDetailState(
    val level: String,
    val description: String,
)

data class HeldItemUpgradeState(
    val description: String,
    val image: String,
    val isClicked: Boolean,
)

sealed class HeldItemDetailEvent {
    class ClickUpgrade(
        val upgrade: HeldItemUpgradeState,
    ) : HeldItemDetailEvent()

    class ClickStat(
        val stat: HeldItemStatState,
    ) : HeldItemDetailEvent()
}
