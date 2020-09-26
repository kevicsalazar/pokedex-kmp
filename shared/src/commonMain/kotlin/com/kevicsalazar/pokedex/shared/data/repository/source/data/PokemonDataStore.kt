package com.kevicsalazar.pokedex.shared.data.repository.source.data

import com.kevicsalazar.pokedex.db.Pokemon
import com.kevicsalazar.pokedex.db.PokemonQueries
import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonDto
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow

class PokemonDataStore(private val queries: PokemonQueries) {

    fun insert(list: List<PokemonDto.Item>) {
        queries.transaction {
            list.forEachIndexed { index, item ->
                queries.insertItem(index.toLong(), item.name, item.url)
            }
        }
    }

    fun selectAll(): Flow<List<Pokemon>> {
        return queries.selectAll().asFlow().mapToList()
    }

    fun hasItems(): Boolean {
        return queries.count().executeAsOne() > 0
    }

}