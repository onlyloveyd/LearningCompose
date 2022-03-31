package tech.kicky.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.kicky.compose.graphics.GraphicsSample
import tech.kicky.compose.ui.theme.LearningComposeTheme
import tech.kicky.compose.ui.theme.Purple200
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { Home(navController) }
                    composable("textSample") { TextSample(navController) }
                    composable("buttonSample") { ButtonSample(navController) }
                    composable("listSample") { ListSample(navController) }
                    composable("graphicsSample") { GraphicsSample() }
                }
            }
        }
    }
}

@Composable
fun Home(navController: NavController) {
    val router = listOf(
        "Text" to "textSample",
        "Button" to "buttonSample",
        "List" to "ListSample",
        "Graphics" to "GraphicsSample",
    )
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(router) {

            Box(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(it.second)
                }) {
                Text(
                    text = it.first,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 12.dp)
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Purple200)
            )
        }
    }
}

