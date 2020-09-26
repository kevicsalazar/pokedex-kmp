package com.kevicsalazar.pokedex.shared.domain.usecases

import com.kevicsalazar.pokedex.shared.domain.repository.PokemonRepository

class SyncPokemonListUseCase(
    private val pokemonRepository: PokemonRepository
) {

    suspend fun syncPokemonList(isForced: Boolean) {
        pokemonRepository.fetchPokemonList(isForced)
    }

}