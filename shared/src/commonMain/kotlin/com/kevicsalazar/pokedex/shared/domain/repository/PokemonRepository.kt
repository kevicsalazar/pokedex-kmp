package com.kevicsalazar.pokedex.shared.domain.repository

import com.kevicsalazar.pokedex.shared.domain.entities.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemonList(): Flow<List<Pokemon>>

    suspend fun fetchPokemonList(isForced: Boolean)

}