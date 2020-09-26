package com.kevicsalazar.pokedex.shared.di

import com.kevicsalazar.pokedex.shared.features.list.PokemonListViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider


actual val viewModelModule = DI.Module("ViewModel") {

    bind() from provider { PokemonListViewModel(instance()) }

}

actual val dbModule = DI.Module("Database") {

}