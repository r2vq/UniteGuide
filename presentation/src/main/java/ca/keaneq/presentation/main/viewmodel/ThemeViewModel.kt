package ca.keaneq.presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.keaneq.domain.model.Theme
import ca.keaneq.domain.usecase.GetThemeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    getThemeUseCase: GetThemeUseCase,
) : ViewModel() {
    val theme: StateFlow<Theme> = getThemeUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, Theme.System)
}