package com.kevicsalazar.pokedex.shared.data.repository.mappers

import com.kevicsalazar.pokedex.shared.domain.entities.Pokemon
import com.kevicsalazar.pokedex.db.Pokemon as PokemonEntity

class PokemonMapper {

    fun mapToDomainModel(list: List<PokemonEntity>): List<Pokemon> {
        return list.map { mapToDomainModel(it) }
    }

    private fun mapToDomainModel(item: PokemonEntity): Pokemon {
        return Pokemon(item.name, item.url)
    }

}