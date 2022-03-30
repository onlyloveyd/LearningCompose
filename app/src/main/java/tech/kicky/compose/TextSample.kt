package tech.kicky.compose

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tech.kicky.compose.extension.AppLog
import tech.kicky.compose.ui.theme.Purple200
import tech.kicky.compose.ui.theme.Purple500
import tech.kicky.compose.ui.theme.Purple700

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TextSample(navController: NavController) {
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
        items(5) {
            Text(text = "这无止息地吹刮着的激怒的风，", fontFamily = fontFamilyList[it])
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
        val textDecorations = listOf(
            TextDecoration.None,
            TextDecoration.Underline,
            TextDecoration.LineThrough,
            TextDecoration.Underline + TextDecoration.LineThrough
        )
        items(3) {
            Text(text = "——然后我死了，", textDecoration = textDecorations[it])
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
        val textOverflows = listOf(
            TextOverflow.Clip,
            TextOverflow.Ellipsis,
            TextOverflow.Visible
        )
        items(3) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "上帝,请赐予我平静, 去接受我无法改变的. 给予我勇气, 去改变我能改变的, 赐我智慧, 分辨这两者的区别.",
                overflow = textOverflows[it],
                maxLines = 1
            )
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
            SectionTitle("softWrap")
        }
        item {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "上帝, 请赐予我平静, 去接受我无法改变的. 给予我勇气, 去改变我能改变的, 赐我智慧, 分辨这两者的区别.",
                onTextLayout = {
                    AppLog("size: ${it.size}")
                }
            )
        }
        // Text Style TextDirection
        stickyHeader {
            SectionTitle("textStyle: textDirection")
        }
        val directions = listOf(
            TextDirection.Ltr,
            TextDirection.Rtl,
            TextDirection.Content,
            TextDirection.ContentOrLtr,
            TextDirection.ContentOrRtl
        )
        items(5) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Learning Jetpack Compose",
                style = TextStyle(
                    color = Color.Cyan,
                    textDirection = directions[it],
                )
            )
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