package com.kevicsalazar.pokedex.shared.data.network

import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonDto
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class PokemonApi(private val httpClient: HttpClient) {

    suspend fun getPokemonList(): PokemonDto {
        val format = Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
        val url = "https://pokeapi.co/api/v2/pokemon"
        val json = httpClient.get<String>(url)
        return format.decodeFromString(json)
    }

}