package com.kevicsalazar.pokedex.shared.di

import com.kevicsalazar.pokedex.shared.data.network.ApiClient
import com.kevicsalazar.pokedex.shared.data.network.PokemonApi
import com.kevicsalazar.pokedex.shared.data.repository.PokemonDataRepository
import com.kevicsalazar.pokedex.shared.data.repository.mappers.PokemonMapper
import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonCloudStore
import com.kevicsalazar.pokedex.shared.data.repository.source.data.PokemonDataStore
import com.kevicsalazar.pokedex.shared.domain.repository.PokemonRepository
import com.kevicsalazar.pokedex.shared.domain.usecases.GetPokemonListUseCase
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import org.kodein.di.*

val commonModule = DI.Module("Common") {
    import(useCasesModule)
    import(repositoryModule)
    import(networkModule)
}

val useCasesModule = DI.Module("UseCases") {
    bind() from provider { GetPokemonListUseCase(instance()) }
}

val repositoryModule = DI.Module("Repository") {
    bind<PokemonRepository>() with provider {
        PokemonDataRepository(
            instance(),
            instance(),
            instance()
        )
    }
    bind() from provider { PokemonDataStore() }
    bind() from provider { PokemonCloudStore(instance()) }
    bind() from provider { PokemonMapper() }
}

val networkModule = DI.Module("Network") {
    bind() from singleton { ApiClient.get() }
    bind() from provider { PokemonApi(instance()) }
}