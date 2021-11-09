package ca.keaneq.presentation.model

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ca.keaneq.presentation.R
import ca.keaneq.presentation.main.*

enum class RoleItem(
    @StringRes val text: Int,
    val color: @Composable () -> Color,
    val onColor: @Composable () -> Color,
) {
    ALL_ROUNDER(
        text = R.string.role_all_rounder,
        color = { MaterialTheme.colors.allRounder },
        onColor = { MaterialTheme.colors.onAllRounder }),
    ATTACKER(
        text = R.string.role_attacker,
        color = { MaterialTheme.colors.attacker },
        onColor = { MaterialTheme.colors.onAttacker }),
    DEFENDER(
        text = R.string.role_defender,
        color = { MaterialTheme.colors.defender },
        onColor = { MaterialTheme.colors.onDefender }
    ),
    SPEEDSTER(
        text = R.string.role_speedster,
        color = { MaterialTheme.colors.speedster },
        onColor = { MaterialTheme.colors.onSpeedster }
    ),
    SUPPORTER(
        text = R.string.role_supporter,
        color = { MaterialTheme.colors.supporter },
        onColor = { MaterialTheme.colors.onSupporter }
    ),
    UNSPECIFIED(
        text = R.string.role_unspecified,
        color = { MaterialTheme.colors.unspecified },
        onColor = { MaterialTheme.colors.onUnspecified }
    ),
}