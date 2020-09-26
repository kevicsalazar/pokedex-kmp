package com.kevicsalazar.pokedex.shared.domain.usecases

import com.kevicsalazar.pokedex.shared.domain.entities.Pokemon
import com.kevicsalazar.pokedex.shared.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonListUseCase(
    private val pokemonRepository: PokemonRepository
) {

    fun getPokemonList(): Flow<List<Pokemon>> {
        return pokemonRepository.getPokemonList()
    }

}