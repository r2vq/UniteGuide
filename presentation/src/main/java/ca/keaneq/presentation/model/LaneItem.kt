package ca.keaneq.presentation.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ca.keaneq.domain.model.Lane
import ca.keaneq.presentation.R

enum class LaneItem(
    @StringRes val text: Int
) {
    TOP(
        R.string.lane_top
    ),
    CENTER(
        R.string.lane_center
    ),
    BOTTOM(
        R.string.lane_bottom
    ),
    UNSPECIFIED(
        R.string.lane_unspecified
    ),
}

val Lane.text
    @Composable
    get() = stringResource(
        when (this) {
            Lane.TOP -> R.string.lane_top
            Lane.CENTER -> R.string.lane_center
            Lane.BOTTOM -> R.string.lane_bottom
            Lane.UNSPECIFIED -> R.string.lane_unspecified
        }
    )