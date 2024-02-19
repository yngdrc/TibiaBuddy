package app.aventurine.tibiabuddy.instances

import app.aventurine.tibiabuddy.api.tibiaData.TibiaDataApiService
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitInstance @Inject constructor(
    flipperInstance: FlipperInstance
) {
    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addNetworkInterceptor(FlipperOkhttpInterceptor(flipperInstance.networkFlipperPlugin))
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