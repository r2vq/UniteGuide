package ca.keaneq.uniteguide.data.repository.impl

import ca.keaneq.uniteguide.data.network.PokeApi
import ca.keaneq.uniteguide.data.network.dto.PokemonDTO
import ca.keaneq.uniteguide.data.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: PokeApi
) : Repository {
    override suspend fun getPokemon(id: String): PokemonDTO? = api
        .getPokemon()
        .pokemon
        .firstOrNull { it.id == id }

    override suspend fun getPokemonList(): List<PokemonDTO> = api
        .getPokemon()
        .pokemon
}