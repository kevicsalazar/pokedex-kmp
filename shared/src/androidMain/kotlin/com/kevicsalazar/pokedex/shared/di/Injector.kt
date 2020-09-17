package com.kevicsalazar.pokedex.shared.di

import com.kevicsalazar.pokedex.shared.features.list.PokemonListViewModel
import com.kevicsalazar.pokedex.shared.utils.ViewModelFactory
import com.kevicsalazar.pokedex.shared.utils.bindViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object Injector {

    val sharedModule = DI.Module("Shared") {
        importAll(commonModule, viewModelModule)
    }

}

private val viewModelModule = DI.Module("viewModel") {

    bind() from provider { ViewModelFactory(directDI) }

    bindViewModel<PokemonListViewModel>() with provider { PokemonListViewModel(instance()) }
}