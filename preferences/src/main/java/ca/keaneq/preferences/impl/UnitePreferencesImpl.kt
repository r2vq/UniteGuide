package ca.keaneq.preferences.impl

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import ca.keaneq.preferences.UnitePreferences
import ca.keaneq.preferences.model.PreferencesKey
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

internal class UnitePreferencesImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : UnitePreferences {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    override suspend fun <T> setValue(preferencesKey: PreferencesKey<T>, value: T) {
        context.dataStore.edit { settings ->
            settings[preferencesKey.key] = value
        }
    }

    override fun <T> valueFlow(preferencesKey: PreferencesKey<T>): Flow<T> =
        context.dataStore.data.mapNotNull { preferences ->
            preferences[preferencesKey.key]
        }
}