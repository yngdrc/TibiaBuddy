package com.aventurine.tibiabuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.aventurine.tibiabuddy.api.RetrofitInstance
import com.facebook.flipper.BuildConfig
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.core.FlipperClient
import com.facebook.flipper.core.FlipperObject
import com.facebook.flipper.core.FlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFlipper()

        setContent {
            MainScreen()
        }
    }

    private fun initFlipper() {
        if (!FlipperUtils.shouldEnableFlipper(this.applicationContext))
            return

        SoLoader.init(this.applicationContext, false)
        AndroidFlipperClient.getInstance(this.applicationContext).run {
            addPlugin(NetworkFlipperPlugin())
            start()
        }
    }
}