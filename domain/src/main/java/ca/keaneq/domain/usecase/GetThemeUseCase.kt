package ca.keaneq.domain.usecase

import ca.keaneq.domain.model.Theme
import ca.keaneq.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Get the current [Theme] of the app as a [Flow].
 */
class GetThemeUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Theme> = repository
        .getTheme()
        .map { theme: Int ->
            when (theme) {
                1 -> Theme.Dark
                2 -> Theme.Light
                else -> Theme.System
            }
        }
}