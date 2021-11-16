package ca.keaneq.repository.model

import ca.keaneq.preferences.model.PreferencesKey

/**
 * The list of keys for key-value stores that we're storing in Shared Preferences.
 */
internal object PrefKeys {
    /**
     * The key for the Int that represents the current theme of the app.
     */
    val theme: PreferencesKey<Int> = PreferencesKey.IntPref("theme")
}