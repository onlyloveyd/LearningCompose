package tech.kicky.compose.graphics

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.dp

/**
 * Sample showing how to use CanvasScope to issue drawing commands into
 * a given canvas as well as providing transformations to the drawing environment
 */
@Composable
fun DrawScopeSample() {
    // Sample showing how to use the DrawScope receiver scope to issue
    // drawing commands
    Canvas(Modifier.size(120.dp)) {
        drawRect(color = Color.Gray) // Draw grey background
        // Inset content by 10 pixels on the left/right sides and 12 by the
        // top/bottom
        inset(10.0f, 12.0f) {
            val quadrantSize = size / 2.0f

            // Draw a rectangle within the inset bounds
            drawRect(
                size = quadrantSize,
                color = Color.Red
            )

            rotate(45.0f) {
                drawRect(size = quadrantSize, color = Color.Blue)
            }
        }
    }
}

@Composable
fun DrawScopeBatchedTransformSample() {
    Canvas(Modifier.size(120.dp)) { // CanvasScope
        inset(20.0f) {
            // Use withTransform to batch multiple transformations for 1 or more drawing calls
            // that are to be drawn.
            // This is more efficient than issuing nested translation, rotation and scaling
            // calls as the internal state is saved once before and after instead of multiple
            // times between each transformation if done individually
            withTransform({
                translate(10.0f, 12.0f)
                rotate(45.0f, center)
                scale(2.0f, 0.5f)
            }) {
                drawRect(Color.Cyan)
                drawCircle(Color.Blue)
            }
            drawRect(Color.Red, alpha = 0.25f)
        }
    }
}

@Composable
fun DrawScopeOvalBrushSample() {
    Canvas(Modifier.size(120.dp)) {
        drawOval(
            brush = Brush.linearGradient(listOf(Color.Red, Color.Blue)),
            topLeft = Offset(10f, 10f),
            size = Size(size.width - 20f, size.height - 20f)
        )
    }
}

@Composable
fun DrawScopeOvalColorSample() {
    Canvas(Modifier.size(120.dp)) {
        drawOval(
            color = Color.Cyan,
            topLeft = Offset(10f, 10f),
            size = Size(size.width - 20f, size.height - 20f)
        )
    }
}