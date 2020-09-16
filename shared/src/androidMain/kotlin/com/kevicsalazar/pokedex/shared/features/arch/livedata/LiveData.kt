package com.kevicsalazar.pokedex.shared.features.arch.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.LiveData as ArchLiveData

actual open class LiveData<T>(protected val liveData: ArchLiveData<T>) {

    actual open val value: T?
        get() = liveData.value

    fun observe(owner: LifecycleOwner, observer: Observer<T>) {
        liveData.observe(owner, observer)
    }

}