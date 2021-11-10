package ca.keaneq.presentation.model

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import ca.keaneq.domain.model.Role
import ca.keaneq.presentation.R
import ca.keaneq.presentation.main.*

val Role.color
    @Composable
    get() = when (this) {
        Role.ALL_ROUNDER -> MaterialTheme.colors.allRounder
        Role.ATTACKER -> MaterialTheme.colors.attacker
        Role.DEFENDER -> MaterialTheme.colors.defender
        Role.SPEEDSTER -> MaterialTheme.colors.speedster
        Role.SUPPORTER -> MaterialTheme.colors.supporter
        else -> MaterialTheme.colors.unspecified
    }

val Role.onColor
    @Composable
    get() = when (this) {
        Role.ALL_ROUNDER -> MaterialTheme.colors.onAllRounder
        Role.ATTACKER -> MaterialTheme.colors.onAttacker
        Role.DEFENDER -> MaterialTheme.colors.onDefender
        Role.SPEEDSTER -> MaterialTheme.colors.onSpeedster
        Role.SUPPORTER -> MaterialTheme.colors.onSupporter
        else -> MaterialTheme.colors.onUnspecified
    }

val Role.text
    @Composable
    get() = stringResource(
        when (this) {
            Role.ALL_ROUNDER -> R.string.role_all_rounder
            Role.ATTACKER -> R.string.role_attacker
            Role.DEFENDER -> R.string.role_defender
            Role.SPEEDSTER -> R.string.role_speedster
            Role.SUPPORTER -> R.string.role_supporter
            else -> R.string.role_unspecified
        }
    )

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