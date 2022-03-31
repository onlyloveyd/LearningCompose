package tech.kicky.compose.graphics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import tech.kicky.compose.SectionTitle

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GraphicsSample() {
    LazyColumn {
        stickyHeader {
            SectionTitle(title = "BrushSample")
        }
        item {
            GradientBrushSample()
        }

        stickyHeader {
            SectionTitle(title = "DrawScopeSample")
        }

        item {
            DrawScopeSample()
        }

        item {
            DrawScopeBatchedTransformSample()
        }

        item {
            DrawScopeOvalBrushSample()
        }

        item {
            DrawScopeOvalColorSample()
        }

        stickyHeader {
            SectionTitle(title = "PathEffectSample")
        }

        item {
            StampedPathEffectSample()
        }
    }
}