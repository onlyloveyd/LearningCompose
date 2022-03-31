package tech.kicky.compose.text

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextOverflowClipSample() {
    Text(
        text = "Hello ".repeat(2),
        modifier = Modifier.size(100.dp, 70.dp).background(Color.Cyan),
        fontSize = 35.sp,
        overflow = TextOverflow.Clip
    )
}

@Composable
fun TextOverflowEllipsisSample() {
    Text(
        text = "Hello ".repeat(2),
        modifier = Modifier.width(100.dp).background(Color.Cyan),
        fontSize = 35.sp,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun TextOverflowVisibleFixedSizeSample() {
    val background = remember { mutableStateOf(Color.Cyan) }
    Box(modifier = Modifier.size(100.dp, 100.dp)) {
        Text(
            text = "Hello ".repeat(2),
            modifier = Modifier.size(100.dp, 70.dp)
                .background(background.value)
                .clickable {
                    background.value = if (background.value == Color.Cyan) {
                        Color.Gray
                    } else {
                        Color.Cyan
                    }
                },
            fontSize = 35.sp,
            overflow = TextOverflow.Visible
        )
    }
}

@Composable
fun TextOverflowVisibleMinHeightSample() {
    val background = remember { mutableStateOf(Color.Cyan) }
    val count = remember { mutableStateOf(1) }
    Box(modifier = Modifier.size(100.dp, 100.dp)) {
        Text(
            text = "Hello".repeat(count.value),
            modifier = Modifier.width(100.dp).heightIn(min = 70.dp)
                .background(background.value)
                .clickable {
                    background.value =
                        if (background.value == Color.Cyan) Color.Gray else Color.Cyan
                    count.value = if (count.value == 1) 2 else 1
                },
            fontSize = 35.sp,
            overflow = TextOverflow.Visible
        )
    }
}