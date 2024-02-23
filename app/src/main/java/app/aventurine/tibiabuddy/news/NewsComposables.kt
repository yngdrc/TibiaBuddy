package app.aventurine.tibiabuddy.news

import android.graphics.Matrix
import android.text.util.Linkify
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
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
import app.aventurine.tibiabuddy.ui.theme.backgroundColor
import app.aventurine.tibiabuddy.ui.theme.cardBackgroundColor
import app.aventurine.tibiabuddy.ui.theme.cardBorderColor
import app.aventurine.tibiabuddy.ui.theme.cardTextColor
import app.aventurine.tibiabuddy.ui.theme.martelFontFamily
import app.aventurine.tibiabuddy.ui.theme.newsTickerDarkBackgroundColor
import com.google.android.material.textview.MaterialTextView

@Composable
fun News(
    news: List<News>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        GreenHeader(text = "News")
        LazyColumn {
            items(count = news.size) { index ->
                NewsItem(news = news[index])
            }
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
            .padding(bottom = 10.dp),
        shape = RectangleShape,
        colors = cardColors(
            containerColor = cardBackgroundColor,
            contentColor = cardTextColor
        ),
        border = BorderStroke(1.dp, cardBorderColor)
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
        ShaderBrush(
            ImageShader(image, TileMode.Mirror, TileMode.Mirror).apply {
                setLocalMatrix(Matrix().apply { setScale(2.5.dp.value, 2.5.dp.value) })
            }
        )
    }

    Row(
        modifier = modifier
            .background(brush = brush)
            .fillMaxWidth()
            .border(.5.dp, Color.Black),
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
    newsTickers: List<News>
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp).shadow(10.dp)
    ) {
        GreenHeader(text = "News Ticker")
        Card(
            shape = RectangleShape,
            colors = cardColors(
                containerColor = cardBackgroundColor,
                contentColor = cardTextColor
            ),
            border = BorderStroke(1.dp, cardBorderColor)
        ) {
            LazyColumn(
                modifier = Modifier.padding(10.dp)
            ) {
                items(count = newsTickers.size) { index ->
                    NewsTickerItem(
                        newsTicker = newsTickers[index],
                        backgroundColor = if (index % 2 == 0)
                            newsTickerDarkBackgroundColor
                        else
                            cardBackgroundColor
                    )
                }
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

@Composable
fun GreenHeader(
    text: String
) {
    val image = ImageBitmap.imageResource(R.drawable.title_background_green)
    val brush = remember(image) {
        ShaderBrush(
            ImageShader(image, TileMode.Mirror, TileMode.Mirror).apply {
                setLocalMatrix(Matrix().apply { setScale(2.5.dp.value, 3.dp.value) })
            }
        )
    }

    Box(
        modifier = Modifier
            .background(brush)
            .fillMaxWidth()
            .border(1.dp, Color.Black)
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            modifier = Modifier.padding(5.dp),
            color = Color.Black,
            fontFamily = martelFontFamily,
            style = LocalTextStyle.current.copy(
                drawStyle = Stroke(
                    miter = 10f,
                    width = 5f,
                    join = StrokeJoin.Round
                )
            ),
        )

        Text(
            text = text,
            fontSize = 20.sp,
            modifier = Modifier.padding(5.dp),
            color = backgroundColor,
            fontFamily = martelFontFamily,
        )
    }
}