package com.aventurine.tibiabuddy.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MarkerCallOut(
    text: String,
    currentZoom: Float
) {
    Card(
        shape = RectangleShape,
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = Modifier
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(5.dp).widthIn(max = 80.dp),
            fontSize = currentZoom.sp,
            textAlign = TextAlign.Center
        )
    }
}