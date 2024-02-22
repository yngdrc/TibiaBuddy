package app.aventurine.tibiabuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import app.aventurine.tibiabuddy.common.AppWebBrowser
import app.aventurine.tibiabuddy.ui.theme.TibiaBuddyTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TibiaBuddyActivity : ComponentActivity() {
    @Inject lateinit var appWebBrowser: AppWebBrowser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TibiaBuddyTheme(
                darkTheme = true
            ) {
                TibiaBuddyScreen()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        appWebBrowser.startService(context = this)
    }

    override fun onStop() {
        super.onStop()
        appWebBrowser.stopService(context = this)
    }
}