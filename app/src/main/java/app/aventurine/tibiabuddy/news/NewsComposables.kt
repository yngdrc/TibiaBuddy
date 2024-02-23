package app.aventurine.tibiabuddy.news

import android.text.util.Linkify
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import app.aventurine.tibiabuddy.R
import app.aventurine.tibiabuddy.api.tibiaData.enums.NewsCategory
import app.aventurine.tibiabuddy.api.tibiaData.news.News
import app.aventurine.tibiabuddy.ui.theme.cardBackgroundColor
import app.aventurine.tibiabuddy.ui.theme.cardBorderColor
import app.aventurine.tibiabuddy.ui.theme.cardTextColor
import app.aventurine.tibiabuddy.ui.theme.newsTickerDarkBackground
import com.google.android.material.textview.MaterialTextView

@Composable
fun News(
    news: List<News>,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(count = news.size) { index ->
            NewsItem(news = news[index])
        }
    }
}

@Composable
fun NewsItem(
    news: News
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RectangleShape,
        colors = cardColors(
            containerColor = cardBackgroundColor,
            contentColor = cardTextColor
        ),
        border = BorderStroke(1.dp, cardBorderColor),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            NewsItemHeader(news = news, modifier = Modifier.padding(bottom = 10.dp))
            AndroidView(
                modifier = Modifier,
                factory = { context ->
                    MaterialTextView(context).apply {
                        linksClickable = true
                        autoLinkMask = Linkify.WEB_URLS
                        setTextColor(cardTextColor.toArgb())
                    }
                },
                update = {
                    it.text = HtmlCompat.fromHtml(
                        news.contentHtml?.replace(
                            regex = Regex("<img.+?>"),
                            replacement = ""
                        ) ?: "",
                        HtmlCompat.FROM_HTML_MODE_LEGACY,
                        null,
                        null
                    )
                }
            )
        }
    }
}

@Composable
fun NewsItemHeader(
    news: News,
    modifier: Modifier
) {
    val image = ImageBitmap.imageResource(R.drawable.newsheadline_background)
    val brush = remember(image) {
        ShaderBrush(ImageShader(image, TileMode.Repeated, TileMode.Mirror))
    }

    Row(
        modifier = modifier
            .background(brush = brush)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = NewsCategory.valueOf(news.category).bigIconRes),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(5.dp)
        )
        Text(
            text = "${news.date} - ",
            color = Color.White,
            fontSize = 10.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        Text(
            text = news.news ?: news.title ?: "",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun NewsTicker(
    newsTickers: List<News>,
    modifier: Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp),
        shape = RectangleShape,
        colors = cardColors(
            containerColor = cardBackgroundColor,
            contentColor = cardTextColor
        ),
        border = BorderStroke(1.dp, cardBorderColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        LazyColumn(
            modifier = modifier.padding(10.dp)
        ) {
            items(count = newsTickers.size) { index ->
                NewsTickerItem(
                    newsTicker = newsTickers[index],
                    backgroundColor = if (index % 2 == 0)
                        newsTickerDarkBackground
                    else
                        cardBackgroundColor
                )
            }
        }
    }
}

@Composable
fun NewsTickerItem(
    newsTicker: News,
    backgroundColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .padding(horizontal = 3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = NewsCategory.valueOf(newsTicker.category).smallIconRes),
            contentDescription = null,
            modifier = Modifier
                .size(11.dp)
        )

        Text(
            text = "${newsTicker.date} - ${newsTicker.content}",
            fontSize = 11.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 3.dp)
        )
    }
}