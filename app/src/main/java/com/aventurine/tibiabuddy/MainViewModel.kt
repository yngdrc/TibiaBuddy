package com.aventurine.tibiabuddy

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aventurine.tibiabuddy.api.RetrofitInstance
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {
    val playersOnline = mutableIntStateOf(0)
    fun getPlayersOnline() {
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.tibiaDataApi.getWorlds()
                playersOnline.intValue = result.worldsData.playersOnline
            } catch (e: Exception) {
                TODO()
            }
        }
    }
}