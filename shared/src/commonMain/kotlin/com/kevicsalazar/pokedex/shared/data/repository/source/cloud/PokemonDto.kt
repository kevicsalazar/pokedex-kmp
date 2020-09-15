package com.kevicsalazar.pokedex.shared.data.repository.source.cloud


class PokemonDto(
    var results: List<Item> = emptyList()
) {
    class Item(
        var name: String = "",
        var url: String = ""
    )
}