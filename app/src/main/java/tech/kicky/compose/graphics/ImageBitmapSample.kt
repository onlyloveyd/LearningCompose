package tech.kicky.compose.graphics

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PixelMap
import androidx.compose.ui.graphics.toPixelMap

/**
 * Sample showing how to obtain a [PixelMap] to query pixel information
 * from an underlying [ImageBitmap]
 */
fun ImageBitmapToPixelMapSample() {
    val imageBitmap = createImageBitmap()

    // Sample a 3 by 2 subsection of the given ImageBitmap
    // starting at the coordinate (48, 49)
    val pixelmap = imageBitmap.toPixelMap(
        startX = 48,
        startY = 49,
        width = 3,
        height = 2
    )

    // create a histogram to count the number of occurrences of a color within the specified
    // subsection of the provided ImageBitmap
    val histogram = HashMap<Color, Int>()
    for (x in 0 until pixelmap.width) {
        for (y in 0 until pixelmap.height) {
            val color = pixelmap[x, y]
            val colorCount = histogram[color] ?: 0
            histogram[color] = (colorCount + 1)
        }
    }
}

/**
 * [ImageBitmap.readPixels] sample that shows how to create a consumer defined
 * IntArray to store pixel information and create a PixelMap for querying information
 * within the buffer
 */
fun ImageBitmapReadPixelsSample() {
    val imageBitmap = createImageBitmap()

    val buffer = IntArray(20 * 10)
    imageBitmap.readPixels(
        buffer = buffer,
        startX = 8,
        startY = 9,
        width = 20,
        height = 10
    )

    val pixelmap = PixelMap(
        buffer = buffer,
        width = 20,
        height = 10,
        stride = 20,
        bufferOffset = 0
    )

    // create a histogram to count the number of occurrences of a color within the specified
    // subsection of the provided ImageBitmap
    val histogram = HashMap<Color, Int>()
    for (x in 0 until pixelmap.width) {
        for (y in 0 until pixelmap.height) {
            val color = pixelmap[x, y]
            val colorCount = histogram[color] ?: 0
            histogram[color] = (colorCount + 1)
        }
    }
}

private fun createImageBitmap(): ImageBitmap {
    val imageBitmap = ImageBitmap(100, 100)
    val canvas = Canvas(imageBitmap)
    val paint = Paint()

    // Draw 4 colored squares that are red, blue, green and yellow from the top left, top right
    // bottom left and bottom right respectively
    paint.color = Color.Red
    canvas.drawRect(Rect(0.0f, 0.0f, 50.0f, 50.0f), paint)

    paint.color = Color.Blue
    canvas.drawRect(Rect(50.0f, 0.0f, 100.0f, 50.0f), paint)

    paint.color = Color.Green
    canvas.drawRect(Rect(0.0f, 50.0f, 50.0f, 100.0f), paint)

    paint.color = Color.Yellow
    canvas.drawRect(Rect(50.0f, 50.0f, 100.0f, 100.0f), paint)
    return imageBitmap
}
