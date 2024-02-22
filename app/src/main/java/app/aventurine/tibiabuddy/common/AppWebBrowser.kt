package app.aventurine.tibiabuddy.common

import android.content.ComponentName
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.provider.Browser
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsCallback
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsService
import androidx.browser.customtabs.CustomTabsServiceConnection
import androidx.browser.customtabs.CustomTabsSession
import dagger.hilt.android.qualifiers.ApplicationContext
import net.openid.appauth.browser.AnyBrowserMatcher
import net.openid.appauth.browser.BrowserSelector
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppWebBrowser @Inject constructor(
    @ApplicationContext private val applicationContext: Context
) {
    private var mSession: CustomTabsSession? = null
    private var mConnection: CustomTabsServiceConnection? = null

    private val mCallback = object : CustomTabsCallback() {
        override fun onRelationshipValidationResult(
            relation: Int,
            requestedOrigin: Uri,
            result: Boolean,
            extras: Bundle?
        ) {
            super.onRelationshipValidationResult(relation, requestedOrigin, result, extras)
            Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun startService(context: Context) {
        mConnection = object : CustomTabsServiceConnection() {
            override fun onCustomTabsServiceConnected(
                name: ComponentName,
                client: CustomTabsClient
            ) {
                mSession = client.newSession(mCallback)
                client.warmup(0)

                mSession?.validateRelationship(
                    CustomTabsService.RELATION_USE_AS_ORIGIN,
                    Uri.parse("https://aventurine.app/"),
                    null
                )
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                Toast.makeText(applicationContext, "Stopped", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        val packageName = CustomTabsClient.getPackageName(
            context,
            listOf(context.preferredBrowser),
            false
        )

        if (packageName == null) {
            Toast.makeText(applicationContext, "Package name is null.", Toast.LENGTH_SHORT)
                .show()
        } else {
            CustomTabsClient.bindCustomTabsService(context, packageName, mConnection!!)
        }
    }

    fun stopService(context: Context) {
        context.unbindService(mConnection ?: return)
        mSession = null
        mConnection = null
    }

    fun launchUrl(
        url: Uri = Uri.parse("https://aventurine.app/api/profile"),
        context: Context
    ) {
        val intent = CustomTabsIntent.Builder().build()

        val headers = Bundle()
        headers.putString(
            "Authorization",
            ""
        )
        intent.intent.putExtra(Browser.EXTRA_HEADERS, headers)
        context.preferredBrowser?.let { intent.intent.`package` = it }
        intent.launchUrl(context, url)
    }

    private val Context.preferredBrowser
        get() = BrowserSelector.select(this, AnyBrowserMatcher.INSTANCE)?.packageName
}