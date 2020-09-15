package com.kevicsalazar.pokedex.shared.domain.repository

import com.kevicsalazar.pokedex.shared.domain.entities.Pokemon

interface PokemonRepository {

    suspend fun getPokemonList(): List<Pokemon>

}