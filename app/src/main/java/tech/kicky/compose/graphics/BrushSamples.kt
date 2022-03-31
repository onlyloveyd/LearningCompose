package tech.kicky.compose.graphics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GradientBrushSample() {
    Column(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize()) {

        // Create a linear gradient that shows red in the top left corner
        // and blue in the bottom right corner
        val linear = Brush.linearGradient(listOf(Color.Red, Color.Blue))

        Box(modifier = Modifier
            .size(120.dp)
            .background(linear))

        Spacer(modifier = Modifier.size(20.dp))

        // Create a radial gradient centered about the drawing area that is green on
        // the outer
        // edge of the circle and magenta towards the center of the circle
        val radial = Brush.radialGradient(listOf(Color.Green, Color.Magenta))
        Box(modifier = Modifier
            .size(120.dp)
            .background(radial))

        Spacer(modifier = Modifier.size(20.dp))

        // Create a radial gradient centered about the drawing area that is green on
        // the outer
        // edge of the circle and magenta towards the center of the circle
        val sweep = Brush.sweepGradient(listOf(Color.Cyan, Color.Magenta))
        Box(modifier = Modifier
            .size(120.dp)
            .background(sweep))
    }
}
