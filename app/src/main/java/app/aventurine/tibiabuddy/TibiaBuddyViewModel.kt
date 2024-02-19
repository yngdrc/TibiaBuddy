package app.aventurine.tibiabuddy

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.aventurine.tibiabuddy.instances.RetrofitInstance
import app.aventurine.tibiabuddy.common.AppWebBrowser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class TibiaBuddyViewModel @Inject constructor(
    private val retrofitInstance: RetrofitInstance,
    val appWebBrowser: AppWebBrowser
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