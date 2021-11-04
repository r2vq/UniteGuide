package ca.keaneq.uniteguide.presentation.model

import androidx.annotation.StringRes
import ca.keaneq.uniteguide.R

enum class AttackStyleItem(
    @StringRes val text: Int
) {
    RANGED(R.string.attack_style_ranged),
    MELEE(R.string.attack_style_melee),
    UNSPECIFIED(R.string.attack_style_unspecified),
}