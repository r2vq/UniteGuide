package ca.keaneq.preferences

import ca.keaneq.preferences.model.PreferencesKey
import kotlinx.coroutines.flow.Flow

/**
 * Set and retrieve SharedPreferences using [PreferencesKey] to identify which value to get.
 *
 * @see PreferencesKey
 */
interface UnitePreferences {
    /**
     * Set a value of type [T] using the appropriate [PreferencesKey]. This is a [suspend] function
     * so it needs to be called on a coroutine.
     *
     * @param T The type of the value to set. This should match the type of [preferencesKey].
     * @param preferencesKey the [PreferencesKey] of the value to set.
     * @param value the value to set.
     */
    suspend fun <T> setValue(preferencesKey: PreferencesKey<T>, value: T)

    /**
     * Retrieve a [Flow] of the value identified by [preferencesKey].
     *
     * @param T The type of the value to retrieve. This should match the type of [preferencesKey].
     * @param preferencesKey the [PreferencesKey] of the value to retrieve.
     * @return A [Flow] of value.
     */
    fun <T> valueFlow(preferencesKey: PreferencesKey<T>): Flow<T>
}