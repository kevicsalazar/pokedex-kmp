package com.kevicsalazar.pokedex.shared.di

import com.kevicsalazar.pokedex.shared.data.db.DriverFactory
import com.kevicsalazar.pokedex.shared.features.list.PokemonListViewModel
import org.kodein.di.*


actual val viewModelModule = DI.Module("ViewModel") {

    bind() from provider { PokemonListViewModel(instance(), instance()) }

}

actual val dbDriverModule = DI.Module("DatabaseDriver") {

    bind() from singleton { DriverFactory().createDriver() }

}