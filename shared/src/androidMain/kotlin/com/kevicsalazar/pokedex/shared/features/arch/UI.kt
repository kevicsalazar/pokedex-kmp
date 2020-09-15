package com.kevicsalazar.pokedex.shared.features.arch

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val Dispatchers.UI: CoroutineDispatcher
    get() = Main