package tech.kicky.compose.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun TextDecorationLineThroughSample() {
    Text(
        text = "Demo Text",
        textDecoration = TextDecoration.LineThrough
    )
}

@Composable
fun TextDecorationUnderlineSample() {
    Text(
        text = "Demo Text",
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun TextDecorationCombinedSample() {
    Text(
        text = "Demo Text",
        textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
    )
}