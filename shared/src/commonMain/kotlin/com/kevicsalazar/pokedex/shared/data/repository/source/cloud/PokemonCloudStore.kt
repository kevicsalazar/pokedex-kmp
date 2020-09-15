package com.kevicsalazar.pokedex.shared.data.repository.source.cloud

import com.kevicsalazar.pokedex.shared.data.network.PokemonApi

class PokemonCloudStore(
    private val pokemonApi: PokemonApi
) {

    suspend fun getPokemonList(): List<PokemonDto.Item> {
        return pokemonApi.getPokemonList().results
    }

}