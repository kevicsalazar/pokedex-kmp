package com.kevicsalazar.pokedex.shared.data.db

import com.squareup.sqldelight.db.SqlDriver

internal val databaseName = "Pokedex.db"

expect class DriverFactory {
    fun createDriver(): SqlDriver
}