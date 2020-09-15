package com.kevicsalazar.pokedex.shared.features.list

import com.kevicsalazar.pokedex.shared.domain.entities.Pokemon

sealed class PokemonListViewState {
    object Loading : PokemonListViewState()
    class Success(val list: List<Pokemon>) : PokemonListViewState()
    class Error(val message: String) : PokemonListViewState()
}