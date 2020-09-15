package com.kevicsalazar.pokedex.shared.features.arch.viewmodel

import com.kevicsalazar.pokedex.shared.features.arch.UI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlin.native.internal.GC

@ThreadLocal
private var isGCWorking = false

actual open class ViewModel actual constructor() {
    // for now dispatcher fixed on Main. after implementing multithread coroutines on native - we can change it
    protected actual val viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.UI)

    actual open fun onCleared() {
        viewModelScope.cancel()
        // run Kotlin/Native GC
        if (!isGCWorking) {
            isGCWorking = true
            GC.collect()
            isGCWorking = false
        }
    }
}