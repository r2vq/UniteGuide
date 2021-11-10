package ca.keaneq.presentation.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ca.keaneq.domain.model.Difficulty
import ca.keaneq.presentation.R

enum class DifficultyItem(
    @StringRes val text: Int
) {
    NOVICE(R.string.difficulty_novice),
    INTERMEDIATE(R.string.difficulty_intermediate),
    EXPERT(R.string.difficulty_expert),
    UNSPECIFIED(R.string.difficulty_unspecified),
}

val Difficulty.text
    @Composable
    get() = stringResource(
        when (this) {
            Difficulty.NOVICE -> R.string.difficulty_novice
            Difficulty.INTERMEDIATE -> R.string.difficulty_intermediate
            Difficulty.EXPERT -> R.string.difficulty_expert
            Difficulty.UNSPECIFIED -> R.string.difficulty_unspecified
        }
    )