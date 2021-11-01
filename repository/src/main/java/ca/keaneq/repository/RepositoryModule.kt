package ca.keaneq.repository

import ca.keaneq.network.PokeApi
import ca.keaneq.repository.impl.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun bindRepository(
        api: PokeApi
    ): Repository = RepositoryImpl(
        api = api
    )
}