package com.kevicsalazar.pokedex.shared.features.arch.livedata

expect open class LiveData<T> {
    open val value: T

    fun addObserver(observer: (T) -> Unit)

    fun removeObserver(observer: (T) -> Unit)
}