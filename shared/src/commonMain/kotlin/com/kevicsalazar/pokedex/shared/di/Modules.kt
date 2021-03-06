package com.kevicsalazar.pokedex.shared.di

import com.kevicsalazar.pokedex.db.PokedexDatabase
import com.kevicsalazar.pokedex.shared.data.network.ApiClient
import com.kevicsalazar.pokedex.shared.data.network.PokemonApi
import com.kevicsalazar.pokedex.shared.data.repository.PokemonDataRepository
import com.kevicsalazar.pokedex.shared.data.repository.mappers.PokemonMapper
import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonCloudStore
import com.kevicsalazar.pokedex.shared.data.repository.source.data.PokemonDataStore
import com.kevicsalazar.pokedex.shared.domain.repository.PokemonRepository
import com.kevicsalazar.pokedex.shared.domain.usecases.GetPokemonListUseCase
import com.kevicsalazar.pokedex.shared.domain.usecases.SyncPokemonListUseCase
import org.kodein.di.*


val sharedModule = DI.Module("Shared") {
    importAll(
        viewModelModule,
        useCasesModule,
        repositoryModule,
        networkModule,
        dbDriverModule,
        dbModule
    )
}

expect val viewModelModule: DI.Module

private val useCasesModule = DI.Module("UseCases") {
    bind() from provider { GetPokemonListUseCase(instance()) }
    bind() from provider { SyncPokemonListUseCase(instance()) }
}

private val repositoryModule = DI.Module("Repository") {
    bind<PokemonRepository>() with provider {
        PokemonDataRepository(
            instance(),
            instance(),
            instance()
        )
    }
    bind() from provider { PokemonDataStore(instance()) }
    bind() from provider { PokemonCloudStore(instance()) }
    bind() from provider { PokemonMapper() }
}

private val networkModule = DI.Module("Network") {
    bind() from singleton { ApiClient.get() }
    bind() from provider { PokemonApi(instance()) }
}

expect val dbDriverModule: DI.Module

private val dbModule = DI.Module("Database") {

    bind() from singleton { PokedexDatabase(instance()) }
    bind() from singleton { instance<PokedexDatabase>().pokemonQueries }

}