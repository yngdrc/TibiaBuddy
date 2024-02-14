package com.aventurine.tibiabuddy

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aventurine.tibiabuddy.api.RetrofitInstance
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val retrofitInstance: RetrofitInstance
) : ViewModel() {
    val playersOnline = mutableIntStateOf(0)

    fun getPlayersOnline() {
        viewModelScope.launch {
            try {
                val result = retrofitInstance.tibiaDataApi.getWorlds()
                playersOnline.intValue = result.worldsData.playersOnline
            } catch (e: Exception) {
                e
            }
        }
    }
}