package com.kevicsalazar.pokedex.shared.data.db

import com.kevicsalazar.pokedex.db.PokedexDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.native.NativeSqliteDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(PokedexDatabase.Schema, "Pokedex.db")
    }
}