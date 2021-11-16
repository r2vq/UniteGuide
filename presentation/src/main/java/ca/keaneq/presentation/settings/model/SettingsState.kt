package ca.keaneq.presentation.settings.model

import androidx.annotation.StringRes

sealed class SettingsState

data class SettingsStateTitle(
    @StringRes val text: Int,
) : SettingsState()

data class SettingsStateDescription(
    @StringRes val title: Int,
    @StringRes val body: Int,
) : SettingsState()

data class SettingsStateRadioOption(
    @StringRes val text: Int,
    val isSelected: Boolean,
    val onClick: () -> Unit
) : SettingsState()