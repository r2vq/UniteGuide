package ca.keaneq.uniteguide.presentation.model

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ca.keaneq.uniteguide.presentation.main.*

enum class RoleItem(
    val color: @Composable () -> Color,
    val onColor: @Composable () -> Color,
) {
    ALL_ROUNDER(
        color = { MaterialTheme.colors.allRounder },
        onColor = { MaterialTheme.colors.onAllRounder }),
    ATTACKER(
        color = { MaterialTheme.colors.attacker },
        onColor = { MaterialTheme.colors.onAttacker }),
    DEFENDER(
        color = { MaterialTheme.colors.defender },
        onColor = { MaterialTheme.colors.onDefender }
    ),
    SPEEDSTER(
        color = { MaterialTheme.colors.speedster },
        onColor = { MaterialTheme.colors.onSpeedster }
    ),
    SUPPORTER(
        color = { MaterialTheme.colors.supporter },
        onColor = { MaterialTheme.colors.onSupporter }
    ),
    UNSPECIFIED(
        color = { MaterialTheme.colors.unspecified },
        onColor = { MaterialTheme.colors.onUnspecified }
    ),
}