package tech.kicky.compose.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import tech.kicky.compose.R

@Composable
fun FontFamilySansSerifSample() {
    Text(
        text = "Demo Text sans-serif",
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun FontFamilySerifSample() {
    Text(
        text = "Demo Text serif",
        fontFamily = FontFamily.Serif
    )
}

@Composable
fun FontFamilyMonospaceSample() {
    Text(
        text = "Demo Text monospace",
        fontFamily = FontFamily.Monospace
    )
}

@Composable
fun FontFamilyCursiveSample() {
    Text(
        text = "Demo Text cursive",
        fontFamily = FontFamily.Cursive
    )
}

@Composable
fun CustomFontFamilySample() {
    val fontFamily = FontFamily(
        Font(
            resId = R.font.myfont_regular,
            weight = FontWeight.W400,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.myfont_italic,
            weight = FontWeight.W400,
            style = FontStyle.Italic
        )
    )
    Text(text = "Demo Text", fontFamily = fontFamily)
}

@Composable
fun FontFamilySynthesisSample() {
    // The font family contains a single font, with normal weight
    val fontFamily = FontFamily(
        Font(resId = R.font.myfont_regular, weight = FontWeight.Normal)
    )
    // Configuring the Text composable to be bold
    // Using FontSynthesis.Weight to have the system render the font bold my making the glyphs
    // thicker
    Text(
        text = "Demo Text",
        style = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSynthesis = FontSynthesis.Weight
        )
    )
}