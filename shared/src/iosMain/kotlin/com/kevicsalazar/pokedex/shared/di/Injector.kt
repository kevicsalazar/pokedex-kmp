package com.kevicsalazar.pokedex.shared.di

import com.kevicsalazar.pokedex.shared.features.list.PokemonListViewModel
import org.kodein.di.*
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object Injector {

    private val sharedDi = DI.lazy {
        importAll(commonModule, viewModelModule)
    }

    private val viewModelModule = DI.Module("viewModel") {

        bind() from provider { PokemonListViewModel(instance()) }

    }

    fun providePokemonListViewModel() = sharedDi.direct.instance<PokemonListViewModel>()

}