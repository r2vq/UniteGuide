package ca.keaneq.presentation.main.mapper

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import ca.keaneq.domain.model.Role
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
