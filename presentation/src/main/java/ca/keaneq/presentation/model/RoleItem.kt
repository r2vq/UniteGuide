package ca.keaneq.presentation.model

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
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
