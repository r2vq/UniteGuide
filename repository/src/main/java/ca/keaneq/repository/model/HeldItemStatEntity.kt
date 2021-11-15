package ca.keaneq.repository.model

data class HeldItemStatEntity(
    val name: String,
    val detail: List<HeldItemStatDetailEntity>,
)