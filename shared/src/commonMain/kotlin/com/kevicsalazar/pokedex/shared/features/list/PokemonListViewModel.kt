package com.kevicsalazar.pokedex.shared.features.list

import com.kevicsalazar.pokedex.shared.domain.usecases.GetPokemonListUseCase
import com.kevicsalazar.pokedex.shared.features.arch.livedata.LiveData
import com.kevicsalazar.pokedex.shared.features.arch.livedata.MutableLiveData
import com.kevicsalazar.pokedex.shared.features.arch.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase
): ViewModel() {

    val viewState: LiveData<PokemonListViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<PokemonListViewState>(PokemonListViewState.Loading)

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