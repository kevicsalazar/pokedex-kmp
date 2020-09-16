package com.kevicsalazar.pokedex.shared.features.arch.livedata

expect open class LiveData<T> {
    open val value: T?
}