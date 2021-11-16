package ca.keaneq.presentation.settings.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.keaneq.domain.model.Theme
import ca.keaneq.domain.usecase.GetThemeUseCase
import ca.keaneq.domain.usecase.SetThemeUseCase
import ca.keaneq.presentation.R
import ca.keaneq.presentation.settings.model.SettingsState
import ca.keaneq.presentation.settings.model.SettingsStateDescription
import ca.keaneq.presentation.settings.model.SettingsStateRadioOption
import ca.keaneq.presentation.settings.model.SettingsStateTitle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    getThemeUseCase: GetThemeUseCase,
    private val setThemeUseCase: SetThemeUseCase,
) : ViewModel() {
    val settings: StateFlow<List<SettingsState>> = getThemeUseCase()
        .map { theme ->
            listOf(
                SettingsStateTitle(
                    text = R.string.title_settings
                ),
                SettingsStateDescription(
                    title = R.string.settings_title_dark_mode,
                    body = R.string.settings_body_dark_mode
                ),
                SettingsStateRadioOption(
                    text = R.string.settings_option_dark_mode,
                    isSelected = theme == Theme.Dark,
                ) {
                    updateDarkMode(Theme.Dark)
                },
                SettingsStateRadioOption(
                    text = R.string.settings_option_light_mode,
                    isSelected = theme == Theme.Light,
                ) {
                    updateDarkMode(Theme.Light)
                },
                SettingsStateRadioOption(
                    text = R.string.settings_option_system_mode,
                    isSelected = theme == Theme.System,
                ) {
                    updateDarkMode(Theme.System)
                },
            )
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    private fun updateDarkMode(theme: Theme) {
        viewModelScope.launch {
            setThemeUseCase(theme)
        }
    }
}