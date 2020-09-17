package com.kevicsalazar.pokedex.shared.data.network

import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonDto
import io.ktor.client.*
import io.ktor.client.request.*

class PokemonApi(private val httpClient: HttpClient) {

    suspend fun getPokemonList(): PokemonDto {
        val url = "https://pokeapi.co/api/v2/pokemon"
        println("Start Request")
        val dto = httpClient.get<PokemonDto>(url)
        println("End Request")
        return dto
    }

}