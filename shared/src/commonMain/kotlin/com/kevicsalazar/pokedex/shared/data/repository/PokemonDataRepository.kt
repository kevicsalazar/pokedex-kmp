package com.kevicsalazar.pokedex.shared.data.repository

import com.kevicsalazar.pokedex.shared.data.repository.mappers.PokemonMapper
import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonCloudStore
import com.kevicsalazar.pokedex.shared.data.repository.source.data.PokemonDataStore
import com.kevicsalazar.pokedex.shared.domain.repository.PokemonRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class PokemonDataRepository(
    private val dataStore: PokemonDataStore,
    private val cloudStore: PokemonCloudStore,
    private val mapper: PokemonMapper
) : PokemonRepository {

    override fun getPokemonList() = flow {
        emit(dataStore.selectAll())
        fetchPokemonList(isForced = true)
    }.map { mapper.mapToDomainModel(it) }

    override suspend fun fetchPokemonList(isForced: Boolean) {
        delay(2000)
        val list = cloudStore.getPokemonList()
        dataStore.savePokemons(list)
    }

}