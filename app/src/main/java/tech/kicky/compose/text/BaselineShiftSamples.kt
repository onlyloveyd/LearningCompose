package tech.kicky.compose.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun BaselineShiftSample() {
    Text(
        fontSize = 20.sp,
        text = buildAnnotatedString {
            append(text = "Hello")
            withStyle(SpanStyle(baselineShift = BaselineShift.Superscript, fontSize = 16.sp)) {
                append("superscript")
                withStyle(SpanStyle(baselineShift = BaselineShift.Subscript)) {
                    append("subscript")
                }
            }
        }
    )
}

@Composable
fun BaselineShiftAnnotatedStringSample() {
    val annotatedString = buildAnnotatedString {
        append("Text ")
        withStyle(SpanStyle(baselineShift = BaselineShift.Superscript)) {
            append("Demo")
        }
    }
    Text(text = annotatedString)
}