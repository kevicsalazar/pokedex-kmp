package com.kevicsalazar.pokedex.shared.data.repository.mappers

import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonDto
import com.kevicsalazar.pokedex.shared.domain.entities.Pokemon

class PokemonMapper {

    fun map(list: List<PokemonDto.Item>): List<Pokemon> {
        return list.map { map(it) }
    }

    private fun map(item: PokemonDto.Item): Pokemon {
        return Pokemon(item.name, item.url)
    }

}