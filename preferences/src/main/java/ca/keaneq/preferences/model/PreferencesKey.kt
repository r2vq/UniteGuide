package ca.keaneq.preferences.model

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey

/**
 * A list of types we currently store in Shared Preferences. Add to this list to add new types.
 */
sealed class PreferencesKey<T>(
    val key: Preferences.Key<T>
) {
    class IntPref(name: String) : PreferencesKey<Int>(intPreferencesKey(name))
}
