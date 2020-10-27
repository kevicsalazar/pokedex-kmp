package com.kevicsalazar.pokedex.shared.data.network

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.websocket.*

expect val httpClientEngine: HttpClientEngine

object ApiClient {

    fun get(): HttpClient {
        return HttpClient(httpClientEngine) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(json = kotlinx.serialization.json.Json {
                    isLenient = false
                    ignoreUnknownKeys = true
                    allowSpecialFloatingPointValues = true
                    useArrayPolymorphism = false
                })
            }
            install(WebSockets)
        }
    }

}