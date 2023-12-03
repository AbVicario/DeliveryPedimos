package com.abelgarciavicario.deliverypedimos.signin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.time.format.TextStyle

@Composable
fun BasicButton(
    text: String,
    style: TextStyle?,
    width: Dp = 150.dp,
    height: Dp = 56.dp,
    color: Color = darkColorScheme().primary,
    action: () -> Unit
) {

    Row(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
            .background(color)
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
            .size(width=width, height=height)
            .clickable {
                action
            }
    ) {
        Text(text = text)
    }
}
