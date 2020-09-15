package com.kevicsalazar.pokedex.shared.features.arch.livedata

expect open class MutableLiveData<T>(initialValue: T) : LiveData<T> {
    fun postValue(value: T)

    override var value: T
}