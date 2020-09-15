package com.kevicsalazar.pokedex.androidApp.di

import com.kevicsalazar.pokedex.androidApp.features.list.PokemonListViewModel
import com.kevicsalazar.pokedex.androidApp.utils.ViewModelFactory
import com.kevicsalazar.pokedex.androidApp.utils.bindViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider


val viewModelModule = DI.Module("viewModel") {

    bind() from provider { ViewModelFactory(directDI) }

    bindViewModel<PokemonListViewModel>() with provider { PokemonListViewModel(instance()) }
}