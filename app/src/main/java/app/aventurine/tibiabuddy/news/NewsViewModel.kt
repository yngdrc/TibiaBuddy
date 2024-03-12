package app.aventurine.tibiabuddy.news

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.aventurine.tibiabuddy.api.tibiaData.news.News
import app.aventurine.tibiabuddy.instances.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val retrofitInstance: RetrofitInstance
) : ViewModel() {
    val latestNews = mutableStateListOf<News>()
    val newsTickers = mutableStateListOf<News>()

    fun getNews() {
        viewModelScope.launch {
            try {
                val latestNews = retrofitInstance.tibiaDataApi.getLatestNews()
                val result = latestNews.news.map { news ->
                    retrofitInstance.tibiaDataApi.getNewsById(newsId = news.id)
                }.map { news -> news.news }

                this@NewsViewModel.latestNews.clear()
                this@NewsViewModel.latestNews.addAll(result)
            } catch (e: Exception) {

            }
        }
    }

    fun getNewsTickers() {
        viewModelScope.launch {
            try {
                val newsTickers = retrofitInstance.tibiaDataApi.getNewsTickers()
                val result = newsTickers.news.take(5).map { newsTicker ->
                    retrofitInstance.tibiaDataApi.getNewsById(newsId = newsTicker.id)
                }.map { newsTicker -> newsTicker.news }

                this@NewsViewModel.newsTickers.clear()
                this@NewsViewModel.newsTickers.addAll(result)
            } catch (e: Exception) {

            }
        }
    }
}