package com.kevicsalazar.pokedex.androidApp

import android.app.Application
import com.kevicsalazar.pokedex.androidApp.di.viewModelModule
import com.kevicsalazar.pokedex.shared.di.sharedModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class App : Application(), DIAware {

    override val di by DI.lazy {
        import(androidXModule(this@App))
        import(viewModelModule)
        import(sharedModule)
    }

}