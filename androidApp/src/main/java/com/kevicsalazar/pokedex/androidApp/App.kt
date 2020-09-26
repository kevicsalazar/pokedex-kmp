package com.kevicsalazar.pokedex.androidApp

import android.app.Application
import com.kevicsalazar.pokedex.shared.di.Injector
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class App : Application(), DIAware {

    override val di by Injector.init {
        import(androidXModule(this@App))
    }

}