package com.kevicsalazar.pokedex.shared.data.network

import io.ktor.client.engine.*
import io.ktor.client.engine.android.*

actual val httpClientEngine: HttpClientEngine
    get() = Android.create()