package com.kevicsalazar.pokedex.shared.di

import com.kevicsalazar.pokedex.shared.data.network.PokemonApi
import com.kevicsalazar.pokedex.shared.data.repository.PokemonDataRepository
import com.kevicsalazar.pokedex.shared.data.repository.mappers.PokemonMapper
import com.kevicsalazar.pokedex.shared.data.repository.source.cloud.PokemonCloudStore
import com.kevicsalazar.pokedex.shared.data.repository.source.data.PokemonDataStore
import com.kevicsalazar.pokedex.shared.domain.repository.PokemonRepository
import com.kevicsalazar.pokedex.shared.domain.usecases.GetPokemonListUseCase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val sharedModule = DI.Module("Shared") {
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
    bind() from provider { PokemonApi() }
}