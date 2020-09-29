package com.kevicsalazar.pokedex.shared.data.db

import com.squareup.sqldelight.db.SqlDriver

internal const val databaseName = "Pokedex.db"

expect class DriverFactory {
    fun createDriver(): SqlDriver
}