package ca.keaneq.preferences

import ca.keaneq.preferences.impl.UnitePreferencesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesModule {
    @Binds
    @Singleton
    internal abstract fun bindsUnitePreferences(
        unitePreferencesImpl: UnitePreferencesImpl
    ): UnitePreferences
}