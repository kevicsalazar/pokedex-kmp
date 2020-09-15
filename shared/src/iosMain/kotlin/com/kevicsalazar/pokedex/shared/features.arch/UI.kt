package com.kevicsalazar.pokedex.shared.features.arch

import com.kevicsalazar.pokedex.shared.features.arch.viewmodel.UIDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val Dispatchers.UI: CoroutineDispatcher
    get() = UIDispatcher()