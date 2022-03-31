package tech.kicky.compose.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.sp


fun AnnotatedStringConstructorSample() {
    AnnotatedString(
        text = "Hello World",
        // make "Hello" italic.
        spanStyles = listOf(
            AnnotatedString.Range(SpanStyle(fontStyle = FontStyle.Italic), 0, 5)
        ),
        // create two paragraphs with different alignment and indent settings.
        paragraphStyles = listOf(
            AnnotatedString.Range(ParagraphStyle(textAlign = TextAlign.Center), 0, 6),
            AnnotatedString.Range(ParagraphStyle(textIndent = TextIndent(5.sp)), 6, 11)
        )
    )
}


fun AnnotatedStringBuilderSample() {
    with(AnnotatedString.Builder("Hello")) {
        // push green text style so that any appended text will be green
        pushStyle(SpanStyle(color = Color.Green))
        // append new text, this text will be rendered as green
        append(" World")
        // pop the green style
        pop()
        // append a string without style
        append("!")
        // then style the last added word as red, exclamation mark will be red
        addStyle(SpanStyle(color = Color.Red), "Hello World".length, this.length)

        toAnnotatedString()
    }
}


fun AnnotatedStringBuilderPushSample() {
    with(AnnotatedString.Builder()) {
        // push green text color so that any appended text will be rendered green
        pushStyle(SpanStyle(color = Color.Green))
        // append string, this text will be rendered green
        append("Hello")
        // pop the green text style
        pop()
        // append new string, this string will be default color
        append(" World")

        toAnnotatedString()
    }
}

fun AnnotatedStringBuilderPushParagraphStyleSample() {
    with(AnnotatedString.Builder()) {
        // push a ParagraphStyle to be applied to any appended text after this point.
        pushStyle(ParagraphStyle(lineHeight = 18.sp))
        // append a paragraph which will have lineHeight 18.sp
        append("Paragraph One\n")
        // pop the ParagraphStyle
        pop()
        // append new paragraph, this paragraph will not have the line height defined.
        append("Paragraph Two\n")

        toAnnotatedString()
    }
}


fun AnnotatedStringBuilderPushStringAnnotationSample() {
    with(AnnotatedString.Builder()) {
        // push a string annotation to be applied to any appended text after this point.
        pushStringAnnotation("ParagrapLabel", "paragraph1")
        // append a paragraph, the annotation "paragraph1" is attached
        append("Paragraph One\n")
        // pop the annotation
        pop()
        // append new paragraph
        append("Paragraph Two\n")

        toAnnotatedString()
    }
}


fun AnnotatedStringBuilderWithStyleSample() {
    with(AnnotatedString.Builder()) {
        withStyle(SpanStyle(color = Color.Green)) {
            // green text style will be applied to all text in this block
            append("Hello")
        }
        toAnnotatedString()
    }
}


fun AnnotatedStringBuilderLambdaSample() {
    // create an AnnotatedString using the lambda builder
    buildAnnotatedString {
        // append "Hello" with red text color
        withStyle(SpanStyle(color = Color.Red)) {
            append("Hello")
        }
        append(" ")
        // append "Hello" with blue text color
        withStyle(SpanStyle(color = Color.Blue)) {
            append("World!")
        }
    }
}

fun AnnotatedStringAddStringAnnotationSample() {
    with(AnnotatedString.Builder()) {
        append("link: Jetpack Compose")
        // attach a string annotation that stores a URL to the text "Jetpack Compose".
        addStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com/jetpack/compose",
            start = 6,
            end = 21
        )
    }
}