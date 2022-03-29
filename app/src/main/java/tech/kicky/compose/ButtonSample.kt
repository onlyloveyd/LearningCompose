package tech.kicky.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ButtonSample(navController: NavController) {
    Text(text = "Hello Text")
}