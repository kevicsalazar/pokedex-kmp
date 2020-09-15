package com.kevicsalazar.pokedex.shared.domain.usecases

import com.kevicsalazar.pokedex.shared.domain.entities.Pokemon
import com.kevicsalazar.pokedex.shared.domain.repository.PokemonRepository

class GetPokemonListUseCase(
    private val pokemonRepository: PokemonRepository
) {

    suspend fun getPokemonList(): List<Pokemon> {
        return pokemonRepository.getPokemonList()
    }

}