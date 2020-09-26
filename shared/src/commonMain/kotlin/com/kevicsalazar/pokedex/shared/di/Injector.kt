package com.kevicsalazar.pokedex.shared.di

import org.kodein.di.DI
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object Injector {

    val di = init()

    fun init(f: DI.MainBuilder.() -> Unit = {}) = DI.lazy {
        f.invoke(this)
        import(sharedModule)
    }

}