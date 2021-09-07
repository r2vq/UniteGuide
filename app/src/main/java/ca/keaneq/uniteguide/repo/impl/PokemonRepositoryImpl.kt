package ca.keaneq.uniteguide.repo.impl

import ca.keaneq.uniteguide.api.PokeApi
import ca.keaneq.uniteguide.api.model.PokemonResponse
import ca.keaneq.uniteguide.repo.PokemonRepository
import ca.keaneq.uniteguide.repo.model.Pokemon
import ca.keaneq.uniteguide.repo.toPokemon

class PokemonRepositoryImpl(
    private val pokeApi: PokeApi
) : PokemonRepository {

    override suspend fun getPokemon(): List<Pokemon> = pokeApi
        .getPokemon()
        .pokemon
        .map(PokemonResponse::toPokemon)
}