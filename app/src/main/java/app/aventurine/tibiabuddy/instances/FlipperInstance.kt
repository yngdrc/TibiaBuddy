package app.aventurine.tibiabuddy.instances

import android.content.Context
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FlipperInstance @Inject constructor(
    @ApplicationContext applicationContext: Context
) {
    val networkFlipperPlugin: NetworkFlipperPlugin = NetworkFlipperPlugin()

    init {
        if (FlipperUtils.shouldEnableFlipper(applicationContext)) {
            SoLoader.init(applicationContext, false)
            AndroidFlipperClient.getInstance(applicationContext).run {
                addPlugin(networkFlipperPlugin)
                start()
            }
        }
    }
}