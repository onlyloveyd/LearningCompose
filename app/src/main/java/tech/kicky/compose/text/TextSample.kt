package tech.kicky.compose

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tech.kicky.compose.extension.AppLog
import tech.kicky.compose.text.*
import tech.kicky.compose.ui.theme.Purple200
import tech.kicky.compose.ui.theme.Purple500
import tech.kicky.compose.ui.theme.Purple700

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TextSamples() {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        // Font Size
        stickyHeader {
            SectionTitle(title = "fontSize")
        }
        items(3) {
            Text(text = "假如我是一只鸟，", fontSize = (8 * it).sp)
        }

        // Color
        stickyHeader {
            SectionTitle(title = "color")
        }
        val colors = listOf(Purple200, Purple500, Purple700)
        items(3) {
            Text(text = "我也应该用嘶哑的喉咙歌唱，", color = colors[it])
        }

        // Font Style
        stickyHeader {
            SectionTitle(title = "fontStyle")
        }

        items(2) {
            Text(text = "这被暴风雨所打击着的土地，", fontStyle = FontStyle.values()[it])
        }

        // Font Weight
        stickyHeader {
            SectionTitle(title = "fontWeight")
        }
        items(9) {
            Text(text = "这永远汹涌着我们的悲愤的河流，", fontWeight = FontWeight(100 * (it + 1)))
        }

        // Font Family
        stickyHeader {
            SectionTitle(title = "fontFamily")
        }

        val fontFamilyList = listOf(
            FontFamily.Default,
            FontFamily.Monospace,
            FontFamily.Cursive,
            FontFamily.SansSerif,
            FontFamily.Serif
        )
        item {
            FontFamilySansSerifSample()
            FontFamilySerifSample()
            FontFamilyMonospaceSample()
            FontFamilyCursiveSample()
            CustomFontFamilySample()
            FontFamilySynthesisSample()
        }

        // letterSpacing
        stickyHeader {
            SectionTitle(title = "letterSpacing")
        }
        items(5) {
            Text(text = "和那来自林间的无比温柔的黎明，", letterSpacing = (it * 5).sp)
        }

        // TextDecoration
        stickyHeader {
            SectionTitle(title = "textDecoration")
        }
        item {
            TextDecorationLineThroughSample()
            TextDecorationUnderlineSample()
            TextDecorationCombinedSample()
        }

        // TextAlign
        stickyHeader {
            SectionTitle(title = "textAlign")
        }
        val textAligns = listOf(
            TextAlign.Left,
            TextAlign.Right,
            TextAlign.Center,
            TextAlign.Justify,
            TextAlign.Start,
            TextAlign.End
        )
        items(6) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "——连羽毛也腐烂在土地里面，",
                textAlign = textAligns[it]
            )
        }

        // Line Height
        stickyHeader {
            SectionTitle(title = "lineHeight")
        }
        items(4) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "为什么我的眼里常含泪水？因为我对这土地爱得深沉……，",
                lineHeight = (10 * (it + 1)).sp
            )
        }
        // Text Overflow
        stickyHeader {
            SectionTitle(title = "overflow")
        }
        item {
            TextOverflowClipSample()
            TextOverflowEllipsisSample()
            TextOverflowVisibleFixedSizeSample()
            TextOverflowVisibleMinHeightSample()
        }

        // SoftWrap
        stickyHeader {
            SectionTitle("softWrap")
        }
        items(2) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "上帝, 请赐予我平静, 去接受我无法改变的. 给予我勇气, 去改变我能改变的, 赐我智慧, 分辨这两者的区别.",
                softWrap = it == 1
            )
        }

        // onTextLayout
        stickyHeader {
            SectionTitle("onTextLayout")
        }
        item {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "上帝, 请赐予我平静, 去接受我无法改变的. 给予我勇气, 去改变我能改变的, 赐我智慧, 分辨这两者的区别.",
                onTextLayout = {
                    AppLog("onTextLayout => size: ${it.size}")
                }
            )
        }
        // Text Style
        stickyHeader {
            SectionTitle("textStyle")
        }
        item {
            TextStyleSample()
        }

        // Text Style Shadow
        stickyHeader {
            SectionTitle("textStyle: shadow")
        }
        items(4) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Learning Jetpack Compose",
                style = TextStyle(
                    color = Color.Cyan,
                    shadow = Shadow(
                        color = Color.Red,
                        offset = Offset(0.2f * it, 0.2f * it),
                        blurRadius = 2.0f * it
                    )
                )
            )
        }

        // Span Style
        stickyHeader {
            SectionTitle(title = "SpanStyle")
        }
        item {
            SpanStyleSample()
        }

        // ParagraphStyle
        stickyHeader {
            SectionTitle(title = "ParagraphStyle")
        }
        item {
            ParagraphStyleSample()
            ParagraphStyleAnnotatedStringsSample()
        }

        // 可选择文本
        stickyHeader {
            SectionTitle(title = "Selection Container")
        }
        item {
            SelectionContainer(modifier = Modifier.fillMaxWidth()) {
                Text(text = "You can select me, baby")
            }
        }

        // 可点击文本
        stickyHeader {
            SectionTitle(title = "Clickable Text")
        }
        item {
            Text(text = "使用 clickable 实现点击", modifier = Modifier.clickable {
                AppLog("使用 Text clickable 属性完成点击")
            })
        }
        item {
            ClickableText(
                text = AnnotatedString(
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
                ), onClick = {
                    AppLog("ClickableText 完成点击")
                }
            )
        }

        // AnnotatedString 嵌套样式
        stickyHeader {
            SectionTitle(title = "AnnotatedString")
        }
        item {
            Text(text = with(AnnotatedString.Builder("Hello")) {
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
            })

            Text(text = with(AnnotatedString.Builder()) {
                // push green text color so that any appended text will be rendered green
                pushStyle(SpanStyle(color = Color.Green))
                // append string, this text will be rendered green
                append("Hello")
                // pop the green text style
                pop()
                // append new string, this string will be default color
                append(" World")

                toAnnotatedString()
            })

            Text(text = with(AnnotatedString.Builder()) {
                // push a ParagraphStyle to be applied to any appended text after this point.
                pushStyle(ParagraphStyle(lineHeight = 18.sp))
                // append a paragraph which will have lineHeight 18.sp
                append("Paragraph One\n")
                // pop the ParagraphStyle
                pop()
                // append new paragraph, this paragraph will not have the line height defined.
                append("Paragraph Two\n")

                toAnnotatedString()
            })

            Text(text = with(AnnotatedString.Builder()) {
                // push a string annotation to be applied to any appended text after this point.
                pushStringAnnotation("ParagrapLabel", "paragraph1")
                // append a paragraph, the annotation "paragraph1" is attached
                append("Paragraph One\n")
                // pop the annotation
                pop()
                // append new paragraph
                append("Paragraph Two\n")

                toAnnotatedString()
            })

            Text(text = with(AnnotatedString.Builder()) {
                withStyle(SpanStyle(color = Color.Green)) {
                    // green text style will be applied to all text in this block
                    append("Hello")
                }
                toAnnotatedString()
            })

            Text(text = buildAnnotatedString {
                // append "Hello" with red text color
                withStyle(SpanStyle(color = Color.Red)) {
                    append("Hello")
                }
                append(" ")
                // append "Hello" with blue text color
                withStyle(SpanStyle(color = Color.Blue)) {
                    append("World!")
                }
            })

            val annotatedString = with(AnnotatedString.Builder()) {
                append("link: Jetpack Compose")
                // attach a string annotation that stores a URL to the text "Jetpack Compose".
                addStringAnnotation(
                    tag = "URL",
                    annotation = "https://developer.android.google.cn/jetpack/compose",
                    start = 6,
                    end = 21
                )
                toAnnotatedString()
            }
            ClickableText(
                modifier = Modifier.padding(vertical = 10.dp),
                text = annotatedString,
                onClick = {
                    val annotations = annotatedString.getStringAnnotations(start = 6, end = 21)
                    for (annotation in annotations) {
                        AppLog(annotation.item)
                        AppLog(annotation.tag)
                    }
                })
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple200)
    ) {
        Text(text = title, fontSize = 18.sp)
    }
}