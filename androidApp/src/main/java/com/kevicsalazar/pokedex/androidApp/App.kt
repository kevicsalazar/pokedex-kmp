package com.kevicsalazar.pokedex.androidApp

import android.app.Application
import com.kevicsalazar.pokedex.shared.di.Injector.sharedModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class App : Application(), DIAware {

    override val di by DI.lazy {
        import(androidXModule(this@App))
        import(sharedModule)
    }

}