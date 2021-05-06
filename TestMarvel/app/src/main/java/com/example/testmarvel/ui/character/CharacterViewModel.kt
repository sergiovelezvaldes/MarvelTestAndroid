package com.example.testmarvel.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmarvel.application.common.DispatcherProvider
import com.example.testmarvel.data.common.model.ResultRequest
import com.example.testmarvel.domain.character.model.Character
import com.example.testmarvel.domain.character.usecases.GetCharacterByIdUseCase
import com.example.testmarvel.domain.character.usecases.GetCharactersUseCase
import com.example.testmarvel.ui.common.model.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase) : ViewModel() {

    private val _charactersViewState = MutableLiveData<ViewState<List<Character>>>()
    val charactersViewState: LiveData<ViewState<List<Character>>> get() = _charactersViewState

    private val _characterViewState = MutableLiveData<ViewState<Character>>()
    val characterViewState: LiveData<ViewState<Character>> get() = _characterViewState


    fun loadCharacters() {
        viewModelScope.launch(dispatchers.main()) {
            _charactersViewState.value = ViewState.Loading(null)
            _charactersViewState.value = when (val result = getCharactersUseCase.execute()) {
                is ResultRequest.Success -> result.data?.let { ViewState.Data(it) }
                is ResultRequest.Failure -> result.errorData?.let { ViewState.Failure(it) }
            }
        }
    }

    fun loadCharacterById(characterId: Int) {
        viewModelScope.launch(dispatchers.main()) {
            _characterViewState.value = ViewState.Loading(null)
            _characterViewState.value = when (val result = getCharacterByIdUseCase.execute(characterId)) {
                is ResultRequest.Success -> result.data?.let { ViewState.Data(it) }
                is ResultRequest.Failure -> result.errorData?.let { ViewState.Failure(it) }
            }
        }
    }
}