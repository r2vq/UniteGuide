package ca.keaneq.uniteguide.presentation.model

import androidx.annotation.StringRes
import ca.keaneq.uniteguide.R

enum class DifficultyItem(
    @StringRes val text: Int
) {
    NOVICE(R.string.difficulty_novice),
    INTERMEDIATE(R.string.difficulty_intermediate),
    EXPERT(R.string.difficulty_expert),
    UNSPECIFIED(R.string.difficulty_unspecified),
}