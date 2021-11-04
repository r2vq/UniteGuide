package ca.keaneq.uniteguide.presentation.model

import ca.keaneq.domain.model.Evolution

data class EvolutionItem(
    val name: String,
    val level: Int,
    val image: String,
)

fun Evolution.toEvolutionItem(): EvolutionItem = EvolutionItem(
    name = name,
    level = level,
    image = image,
)
