package com.aventurine.tibiabuddy.characters

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aventurine.tibiabuddy.api.RetrofitInstance
import com.aventurine.tibiabuddy.api.tibiaData.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val retrofitInstance: RetrofitInstance
) : ViewModel() {
    val searchQuery = MutableStateFlow("")
    val characters = mutableStateListOf<Character>()

    fun getCharacter(name: String) {
        viewModelScope.launch {
            try {
                val result = retrofitInstance.tibiaDataApi.getCharacter(name = name)
                val character = result.characterData.character
                characters.clear()
                characters.add(character)
            } catch (e: Exception) {
                e
            }
        }
    }
}