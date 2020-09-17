package com.kevicsalazar.pokedex.shared.di

import com.kevicsalazar.pokedex.shared.features.list.PokemonListViewModel
import org.kodein.di.DI
import org.kodein.di.direct
import org.kodein.di.instance
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object Injector {

    private val sharedDi = DI.lazy {
        import(commonModule)
    }

    fun providePokemonListViewModel() = sharedDi.direct.instance<PokemonListViewModel>()

}