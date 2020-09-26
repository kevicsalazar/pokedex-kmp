package com.kevicsalazar.pokedex.shared.data.repository.source.data

import com.kevicsalazar.pokedex.db.PokedexQueries
import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonDto

class PokemonDataStore(private val queries: PokedexQueries) {

    fun savePokemons(list: List<PokemonDto.Item>) {
        queries.transaction {
            list.forEachIndexed { index, item ->
                queries.insertItem(index.toLong(), item.name, item.url)
            }
        }
    }

}