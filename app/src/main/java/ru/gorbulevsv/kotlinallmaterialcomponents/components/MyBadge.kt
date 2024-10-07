package ru.gorbulevsv.kotlinallmaterialcomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

@Composable
fun MyBadge(
    text: String,
    background: Color,
    fontFamily: FontFamily = FontFamily.Default,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Box(modifier = Modifier.background(color = background, shape = RoundedCornerShape(6.dp))) {
        Text(
            text = text,
            modifier = Modifier.padding(8.dp, 2.dp),
            fontFamily = fontFamily,
            color = color
        )
    }
}