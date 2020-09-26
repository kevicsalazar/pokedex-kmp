package com.kevicsalazar.pokedex.shared.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow

fun <T> Flow<T>.doAction(action: suspend () -> Unit): Flow<T> = combine(flow {
    emit(action.invoke())
}) { original, _ -> original }