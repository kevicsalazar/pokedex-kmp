package com.kevicsalazar.pokedex.shared.data.db

import android.content.Context
import com.kevicsalazar.pokedex.db.PokedexDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(PokedexDatabase.Schema, context, databaseName)
    }
}
