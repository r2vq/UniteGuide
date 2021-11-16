package ca.keaneq.presentation.settings

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.presentation.settings.component.SettingsDescription
import ca.keaneq.presentation.settings.component.SettingsRadioOption
import ca.keaneq.presentation.settings.component.SettingsTitle
import ca.keaneq.presentation.settings.model.SettingsStateDescription
import ca.keaneq.presentation.settings.model.SettingsStateRadioOption
import ca.keaneq.presentation.settings.model.SettingsStateTitle
import ca.keaneq.presentation.settings.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel = hiltViewModel()
) {
    val settings = settingsViewModel.settings.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(settings) { settingsState ->
            when (settingsState) {
                is SettingsStateTitle -> SettingsTitle(
                    text = stringResource(settingsState.text),
                )
                is SettingsStateDescription -> SettingsDescription(
                    title = stringResource(settingsState.title),
                    body = stringResource(settingsState.body),
                )
                is SettingsStateRadioOption -> SettingsRadioOption(
                    text = stringResource(settingsState.text),
                    isEnabled = settingsState.isSelected,
                    onClick = settingsState.onClick,
                )
            }
        }
    }
}