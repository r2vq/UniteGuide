package ca.keaneq.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ca.keaneq.domain.model.AttackType
import ca.keaneq.presentation.R

val AttackType.text
    @Composable
    get() = stringResource(
        when (this) {
            AttackType.PHYSICAL -> R.string.attack_type_physical
            AttackType.SPECIAL -> R.string.attack_type_special
            AttackType.UNSPECIFIED -> R.string.attack_style_unspecified
        }
    )