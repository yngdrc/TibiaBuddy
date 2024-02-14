package com.aventurine.tibiabuddy.api

import android.app.Application
import android.content.Context
import com.aventurine.tibiabuddy.api.tibiaData.TibiaDataApiService
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitInstance @Inject constructor(
    @ApplicationContext applicationContext: Context
) {
    private val networkFlipperPlugin: NetworkFlipperPlugin? by lazy {
        AndroidFlipperClient
            .getInstance(applicationContext)
            .getPluginByClass(NetworkFlipperPlugin::class.java)
    }

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addNetworkInterceptor(FlipperOkhttpInterceptor(networkFlipperPlugin))
            .build()
    }

    val tibiaDataApi: TibiaDataApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl("https://api.tibiadata.com/")
            .build()
            .create(TibiaDataApiService::class.java)
    }
}