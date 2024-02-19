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
        headers.putString("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiZTNmMjY2YjRhODc4YTZhMGUxZDc5NGYyMjZjM2ExOWZjMWI4ZmQ0NTg1Zjk2YWFjNzg3MmYwZjQ2M2ZhZjNmM2Y4MDdkYzJiOTQ0MTViMzkiLCJpYXQiOjE3MDgyMjI2ODIuMDM4NzMzLCJuYmYiOjE3MDgyMjI2ODIuMDM4NzM2LCJleHAiOjE3Mzk4NDUwODIuMDMzMjk1LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.HbtvzRFrICWYW718gk0rYiahdppypnljFfFpO0_ZP2j52v7IEvHh7WtFRN-Tm7cxzeDmSldTZ9obZr7WfXy_0U5w7Ok374fmVQ-kqfw6c9XuYXqwNNmvL8KvQ4Qd3_VXOLwqvB4kS7UVo3kIdQLQSalVvdwVHK5IvREdSOw_HKkn1FEjAFg3qopCTsFcWKwAnwrn0krSncNXSC_Ac2CgnhyVvaMSahKR1cbt4Zk9261GxaIbyjCi-mIxspbbjOJO6PQxZpMLktb1SxOFH__yzrBAUEhbm1FixIV7JDThHw274q3PsrkyiLs2cjcB4H9uAhMwZnj6wXXN9Ayn9XiUVQ-sfxzHOwnC372LjVuddk-javQ_JkVYJs44d9antNu3oS86sn6pZSBN7x1O_iC_M9eUbscMUugXb-f5pSP75RtDNW94qw-tm8L6IkpeqW1KvMGLsgfspPNi1DhscAOTVK_JJnOK39SM_3b8-ytZxphJB6OP5Z_Nckiszk_aBwNoHllA6lCaw1xwlmU4mHKWFFwDMKZfXs8PrHGBsvwrqlenGyMzCWwNB__aNLqskvz6npCIkSaYnFKubmiB49SD4VBRModDVubOx11AZya7IOJrAqwZdKCMOP0ex_t5pPhXROok2G_IKOYp-eRNR9xeOeZy-6_UHFUZBJN4vbiicJY")
        intent.intent.putExtra(Browser.EXTRA_HEADERS, headers)
        context.preferredBrowser?.let { intent.intent.`package` = it }
        intent.launchUrl(context, url)
    }

    private val Context.preferredBrowser
        get() = BrowserSelector.select(this, AnyBrowserMatcher.INSTANCE)?.packageName
}