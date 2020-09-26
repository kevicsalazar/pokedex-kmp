package com.kevicsalazar.pokedex.shared.features.list

import com.kevicsalazar.pokedex.shared.domain.usecases.GetPokemonListUseCase
import com.kevicsalazar.pokedex.shared.domain.usecases.SyncPokemonListUseCase
import com.kevicsalazar.pokedex.shared.features.arch.livedata.LiveData
import com.kevicsalazar.pokedex.shared.features.arch.livedata.MutableLiveData
import com.kevicsalazar.pokedex.shared.features.arch.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val syncPokemonListUseCase: SyncPokemonListUseCase,
) : ViewModel() {

    val viewState: LiveData<PokemonListViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<PokemonListViewState>()

    fun getPokemonList() {
        viewModelScope.launch(exceptionHandler) {
            _viewState.postValue(PokemonListViewState.Loading)
            getPokemonListUseCase.getPokemonList()
                .collect {
                    _viewState.postValue(PokemonListViewState.Success(it))
                }
        }
    }

    fun syncPokemonList() {
        viewModelScope.launch(exceptionHandler) {
            syncPokemonListUseCase.syncPokemonList(true)
        }
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        _viewState.postValue(PokemonListViewState.Error(exception.message.orEmpty()))
    }

}