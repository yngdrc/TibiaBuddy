package app.aventurine.tibiabuddy.news

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import app.aventurine.tibiabuddy.ui.theme.backgroundColor

@Composable
fun NewsScreen(
    newsViewModel: NewsViewModel
) {
    LaunchedEffect(Unit) {
        newsViewModel.getNews()
    }

    Scaffold(
        containerColor = backgroundColor
    ) { paddingValues ->
        News(
            news = newsViewModel.news,
            modifier = Modifier.padding(paddingValues)
        )
    }
}