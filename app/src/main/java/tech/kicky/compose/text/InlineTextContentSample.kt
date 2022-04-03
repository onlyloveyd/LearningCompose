package tech.kicky.compose.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.em

@Composable
fun InlineTextContentSample() {
    val myId = "inlineContent"
    val text = buildAnnotatedString {
        append("Hello")
        // Append a placeholder string "[myBox]" and attach an annotation "inlineContent" on it.
        appendInlineContent(myId, "[myBox]")
    }

    val inlineContent = mapOf(
        Pair(
            // This tells the [BasicText] to replace the placeholder string "[myBox]" by
            // the composable given in the [InlineTextContent] object.
            myId,
            InlineTextContent(
                // Placeholder tells text layout the expected size and vertical alignment of
                // children composable.
                Placeholder(
                    width = 0.5.em,
                    height = 0.5.em,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
                )
            ) {
                // This [Box] will fill maximum size, which is specified by the [Placeholder]
                // above. Notice the width and height in [Placeholder] are specified in TextUnit,
                // and are converted into pixel by text layout.
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Red))
            }
        )
    )

    Text(text = text, inlineContent = inlineContent)
}