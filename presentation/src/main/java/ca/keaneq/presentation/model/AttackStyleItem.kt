package ca.keaneq.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ca.keaneq.domain.model.AttackStyle
import ca.keaneq.presentation.R

val AttackStyle.text
    @Composable
    get() = stringResource(
        when (this) {
            AttackStyle.RANGED -> R.string.attack_style_ranged
            AttackStyle.MELEE -> R.string.attack_style_melee
            AttackStyle.UNSPECIFIED -> R.string.attack_style_unspecified
        }
    )