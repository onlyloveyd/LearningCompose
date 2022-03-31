package tech.kicky.compose.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun SpanStyleSample() {
    Text(
        fontSize = 16.sp,
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Red)) {
                append("Hello")
            }
            withStyle(SpanStyle(color = Color.Blue)) {
                append(" World")
            }
        }
    )
}