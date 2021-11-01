package ca.keaneq.presentation.model

import androidx.annotation.StringRes
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