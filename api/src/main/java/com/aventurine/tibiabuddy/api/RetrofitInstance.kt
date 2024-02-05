package com.aventurine.tibiabuddy.api

import android.app.Application
import android.content.Context
import com.aventurine.tibiabuddy.api.tibiaData.TibiaDataApiService
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    lateinit var tibiaDataApi: TibiaDataApiService

    fun initialize(
        appContext: Context
    ) {
        val networkFlipperPlugin = AndroidFlipperClient
            .getInstance(appContext)
            .getPluginByClass(NetworkFlipperPlugin::class.java)

        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(FlipperOkhttpInterceptor(networkFlipperPlugin))
            .build()

        tibiaDataApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl("https://api.tibiadata.com/")
            .build()
            .create(TibiaDataApiService::class.java)
    }
}