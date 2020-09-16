package com.kevicsalazar.pokedex.shared.features.arch.livedata

actual open class LiveData<T> {

    private var storedValue: T? = null
    private val observers = mutableListOf<(T?) -> Unit>()

    actual open val value: T?
        get() = storedValue

    fun addObserver(observer: (T?) -> Unit) {
        observer(value)
        observers.add(observer)
    }

    fun removeObserver(observer: (T?) -> Unit) {
        observers.remove(observer)
    }

    protected fun changeValue(value: T?) {
        storedValue = value

        observers.forEach { it(value) }
    }
}