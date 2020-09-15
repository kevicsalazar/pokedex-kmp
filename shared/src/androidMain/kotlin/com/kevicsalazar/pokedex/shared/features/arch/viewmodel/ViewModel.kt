package com.kevicsalazar.pokedex.shared.features.arch.viewmodel

import androidx.lifecycle.ViewModel
import com.kevicsalazar.pokedex.shared.features.arch.UI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

actual open class ViewModel actual constructor() : ViewModel() {

    protected actual val viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.UI)

    public actual override fun onCleared() {
        super.onCleared()

        viewModelScope.cancel()
    }
}