package ca.keaneq.repository.impl

import ca.keaneq.network.PokeClient
import ca.keaneq.preferences.UnitePreferences
import ca.keaneq.repository.Repository
import ca.keaneq.repository.mapper.toEntity
import ca.keaneq.repository.model.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import ca.keaneq.network.model.Resource as NetworkResource

internal class RepositoryImpl @Inject constructor(
    private val client: PokeClient,
    private val prefs: UnitePreferences,
) : Repository {

    override suspend fun getPokemonList(): Resource<List<PokemonEntity>> = client
        .getPokemon()
        .let { resource ->
            if (resource is NetworkResource.Success) {
                resource.data
                    ?.pokemon
                    ?.map { pokemon -> pokemon.toEntity() }
                    .let { Resource.Success(it ?: emptyList()) }
            } else {
                Resource.Error(exception = resource.exception)
            }
        }

    override suspend fun getHeldItems(): Resource<List<HeldItemEntity>> = client
        .getHeldItems()
        .let { resource ->
            if (resource is NetworkResource.Success) {
                resource.data
                    ?.items
                    ?.map { item -> item.toEntity() }
                    .let { Resource.Success(it ?: emptyList()) }
            } else {
                Resource.Error(exception = resource.exception)
            }
        }

    override suspend fun setTheme(theme: Int) {
        prefs.setValue(PrefKeys.theme, theme)
    }

    override fun getTheme(): Flow<Int> = prefs
        .valueFlow(PrefKeys.theme)
}