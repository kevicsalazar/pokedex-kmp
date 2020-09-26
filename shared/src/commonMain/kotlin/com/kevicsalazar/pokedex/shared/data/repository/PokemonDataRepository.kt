package com.kevicsalazar.pokedex.shared.data.repository

import com.kevicsalazar.pokedex.shared.data.repository.mappers.PokemonMapper
import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonCloudStore
import com.kevicsalazar.pokedex.shared.data.repository.source.data.PokemonDataStore
import com.kevicsalazar.pokedex.shared.domain.repository.PokemonRepository
import com.kevicsalazar.pokedex.shared.utils.doAction
import kotlinx.coroutines.flow.map

class PokemonDataRepository(
    private val dataStore: PokemonDataStore,
    private val cloudStore: PokemonCloudStore,
    private val mapper: PokemonMapper
) : PokemonRepository {

    override fun getPokemonList() = dataStore.selectAll()
        .doAction { fetchPokemonList(false) }
        .map { mapper.mapToDomainModel(it) }

    override suspend fun fetchPokemonList(isForced: Boolean) {
        if (!dataStore.hasItems() || isForced) {
            val list = cloudStore.getPokemonList()
            dataStore.insert(list)
        }
    }

}