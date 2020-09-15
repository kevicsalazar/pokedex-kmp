package com.kevicsalazar.pokedex.shared.features.arch.viewmodel

import kotlinx.coroutines.CoroutineScope

expect open class ViewModel() {
    protected val viewModelScope: CoroutineScope

    open fun onCleared()
}