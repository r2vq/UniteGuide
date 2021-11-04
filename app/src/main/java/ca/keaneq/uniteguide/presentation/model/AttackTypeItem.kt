package ca.keaneq.uniteguide.presentation.model

import androidx.annotation.StringRes
import ca.keaneq.uniteguide.R

enum class AttackTypeItem(
    @StringRes val text: Int
) {
    PHYSICAL(
        R.string.attack_type_physical,
    ),
    SPECIAL(
        R.string.attack_type_special,
    ),
    UNSPECIFIED(
        R.string.attack_type_unknown,
    ),
}