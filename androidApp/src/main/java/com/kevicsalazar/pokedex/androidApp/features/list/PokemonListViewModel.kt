package com.kevicsalazar.pokedex.androidApp.features.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevicsalazar.pokedex.shared.domain.usecases.GetPokemonListUseCase
import com.kevicsalazar.pokedex.shared.features.list.PokemonListViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    val viewState: LiveData<PokemonListViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<PokemonListViewState>()

    fun getPokemonList() {
        viewModelScope.launch(exceptionHandler) {
            _viewState.postValue(PokemonListViewState.Loading)
            val list = getPokemonListUseCase.getPokemonList()
            _viewState.postValue(PokemonListViewState.Success(list))
        }
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        _viewState.postValue(PokemonListViewState.Error(exception.message.orEmpty()))
    }

}