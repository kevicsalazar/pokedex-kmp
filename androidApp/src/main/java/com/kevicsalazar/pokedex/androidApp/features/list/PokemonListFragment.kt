package com.kevicsalazar.pokedex.androidApp.features.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.kevicsalazar.pokedex.androidApp.databinding.FragmentPokemonListBinding
import com.kevicsalazar.pokedex.androidApp.utils.fragmentViewModel
import com.kevicsalazar.pokedex.shared.features.list.PokemonListViewModel
import com.kevicsalazar.pokedex.shared.features.list.PokemonListViewState
import org.kodein.di.DIAware
import org.kodein.di.android.x.di

class PokemonListFragment : Fragment(), DIAware {

    override val di by di()

    private val viewModel: PokemonListViewModel by fragmentViewModel()

    private lateinit var binding: FragmentPokemonListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner, viewStateObserver)
        viewModel.getPokemonList()
    }

    private val viewStateObserver = Observer<PokemonListViewState> {
        when (it) {
            is PokemonListViewState.Loading -> Log.e("Response", "Loading")
            is PokemonListViewState.Success -> Log.e("Response", it.list.toString())
            is PokemonListViewState.Error -> Log.e("Response", "Error: ${it.message}")
        }
    }

}