package ca.keaneq.presentation.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ca.keaneq.domain.model.AttackStyle
import ca.keaneq.presentation.R

enum class AttackStyleItem(
    @StringRes val text: Int
) {
    RANGED(R.string.attack_style_ranged),
    MELEE(R.string.attack_style_melee),
    UNSPECIFIED(R.string.attack_style_unspecified),
}

val AttackStyle.text
    @Composable
    get() = stringResource(
        when (this) {
            AttackStyle.RANGED -> R.string.attack_style_ranged
            AttackStyle.MELEE -> R.string.attack_style_melee
            AttackStyle.UNSPECIFIED -> R.string.attack_style_unspecified
        }
    )