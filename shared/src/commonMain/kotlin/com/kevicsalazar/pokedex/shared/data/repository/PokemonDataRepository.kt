package com.kevicsalazar.pokedex.shared.data.repository

import com.kevicsalazar.pokedex.shared.data.repository.mappers.PokemonMapper
import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonCloudStore
import com.kevicsalazar.pokedex.shared.data.repository.source.data.PokemonDataStore
import com.kevicsalazar.pokedex.shared.domain.entities.Pokemon
import com.kevicsalazar.pokedex.shared.domain.repository.PokemonRepository

class PokemonDataRepository(
    private val dataStore: PokemonDataStore,
    private val cloudStore: PokemonCloudStore,
    private val mapper: PokemonMapper
) : PokemonRepository{

    override suspend fun getPokemonList(): List<Pokemon> {
        return mapper.map(cloudStore.getPokemonList())
    }

}