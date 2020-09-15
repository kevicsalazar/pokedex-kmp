package com.kevicsalazar.pokedex.androidApp.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kevicsalazar.pokedex.androidApp.features.list.PokemonListFragment
import com.kevicsalazar.pokedex.androidApp.R

class MainActivity : AppCompatActivity() {

    private val pokemonListFragment by lazy { PokemonListFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createFragment()
    }

    private fun createFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, pokemonListFragment)
            .commit()
    }

}