package com.example.learningnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.learningnavigation.ui.theme.LearningNavigationTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.learningnavigation.screens.UVGMyInfoScreen
import com.example.learningnavigation.screens.UserInputForm
import com.example.learningnavigation.screens.UserFormScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningNavigationTheme {
                // Llenamos el Scaffold con el NavigationExamples
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavigationExamples()
                }
            }
        }
    }
}

@Composable
fun NavigationExamples() {
    val navController = rememberNavController()
    var userName by remember { mutableStateOf("") }
    var userAge by remember { mutableStateOf("") }
    var userId by remember { mutableStateOf("") }

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        // Navegación usando NavHost
        NavHost(navController = navController, startDestination = "landingPage") {
            composable(route = "landingPage") {
                UVGMyInfoScreen(navController = navController)
            }
            composable(route = "userInputForm") {
                UserInputForm { name, carnet, age ->
                    // Actualizamos las variables cuando se envían datos del formulario
                    userName = name
                    userId = carnet
                    userAge = age
                    // Navegamos a la pantalla de previsualización
                    navController.navigate("previewInformation")
                }
            }
            composable(route = "previewInformation") {
                // Mostramos la pantalla de previsualización con los datos ingresados
                UserFormScreen(navController = navController, name = userName, age = userAge, carnet = userId)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    NavigationExamples()
}