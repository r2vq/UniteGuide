package ca.keaneq.domain.usecase

import ca.keaneq.domain.model.Theme
import ca.keaneq.repository.Repository
import javax.inject.Inject

/**
 * Set the [Theme]. This is a [suspend] function so it needs to be called in a coroutine.
 */
class SetThemeUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(theme: Theme) {
        repository.setTheme(
            when (theme) {
                Theme.System -> 0
                Theme.Dark -> 1
                Theme.Light -> 2
            }
        )
    }
}