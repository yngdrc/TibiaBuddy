package app.aventurine.tibiabuddy.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.aventurine.tibiabuddy.ui.theme.backgroundColor

@Composable
fun NewsScreen(
    newsViewModel: NewsViewModel
) {
    LaunchedEffect(Unit) {
        newsViewModel.getNews()
        newsViewModel.getNewsTickers()
    }

    Scaffold(
        containerColor = backgroundColor
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(top = 10.dp)
                .padding(horizontal = 10.dp)
                .padding(paddingValues)
        ) {
            NewsTicker(newsTickers = newsViewModel.newsTickers)
            News(news = newsViewModel.latestNews)
        }
    }
}