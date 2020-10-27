package com.kevicsalazar.pokedex.shared.data.network

import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonDto
import com.kevicsalazar.pokedex.shared.utils.Base64Factory
import io.ktor.client.*
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.cio.websocket.*
import io.ktor.utils.io.charsets.*
import io.ktor.utils.io.core.*

class PokemonApi(private val httpClient: HttpClient) {

    suspend fun getPokemonList(): PokemonDto {
        listenSomething()
        val url = "https://pokeapi.co/api/v2/pokemon"
        println("Start Request")
        val dto = httpClient.get<PokemonDto>(url)
        println("End Request")
        return dto
    }

    suspend fun listenSomething() {
        httpClient.ws(
            method = HttpMethod.Get,
            host = "192.168.31.9",
            port = 8123,
            path = "/api/websocket",
            request = {
                header(
                    HttpHeaders.Authorization,
                    "Basic ${
                        Base64Factory.createEncoder().encodeToString(
                        "Kevin:hakevic5u174rpr0".toByteArray(
                            Charsets.UTF_8
                        )
                    )}"
                )
            }
        ) {

            println("TAG 1")

            send("Hello, Text frame")

            println("TAG 2")

            when (val frame = incoming.receive()) {
                is Frame.Text -> println(frame.readText())
                is Frame.Binary -> println(frame.readBytes())
                else -> println(frame.toString())
            }
        }
    }

}