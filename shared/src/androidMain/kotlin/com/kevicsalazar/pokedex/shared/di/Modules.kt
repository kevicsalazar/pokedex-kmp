@file:JvmName("AndroidModules")

package com.kevicsalazar.pokedex.shared.di

import com.kevicsalazar.pokedex.shared.data.db.DriverFactory
import com.kevicsalazar.pokedex.shared.features.list.PokemonListViewModel
import com.kevicsalazar.pokedex.shared.utils.ViewModelFactory
import com.kevicsalazar.pokedex.shared.utils.bindViewModel
import org.kodein.di.*


actual val viewModelModule = DI.Module("ViewModel") {

    bind() from provider { ViewModelFactory(directDI) }

    bindViewModel<PokemonListViewModel>() with provider { PokemonListViewModel(instance(), instance()) }

}

actual val dbDriverModule = DI.Module("DatabaseDriver") {

    bind() from singleton { DriverFactory(instance()).createDriver() }

}