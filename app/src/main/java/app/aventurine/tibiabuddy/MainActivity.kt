package app.aventurine.tibiabuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import app.aventurine.tibiabuddy.ui.map.MapScreen
import app.aventurine.tibiabuddy.ui.theme.TibiaBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TibiaBuddyTheme {
                MapScreen()
            }
        }
    }
}