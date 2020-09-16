package com.kevicsalazar.pokedex.shared.features.arch.livedata

import androidx.lifecycle.MutableLiveData as ArchMutableLiveData

actual open class MutableLiveData<T> : LiveData<T>(ArchMutableLiveData()) {

    actual override var value: T?
        get() = liveData.value
        set(newValue) {
            (liveData as? ArchMutableLiveData<T>)?.value = newValue
        }

    actual fun postValue(value: T?) {
        (liveData as? ArchMutableLiveData<T>)?.postValue(value)
    }

}