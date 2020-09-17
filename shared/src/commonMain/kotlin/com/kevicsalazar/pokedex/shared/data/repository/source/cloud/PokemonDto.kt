package com.kevicsalazar.pokedex.shared.data.repository.source.cloud

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
class PokemonDto(
    @SerialName("results")
    var results: List<Item> = emptyList()
) {
    @Serializable
    class Item(
        @SerialName("name")
        var name: String = "",
        @SerialName("url")
        var url: String = ""
    )
}