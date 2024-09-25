package com.example.learningnavigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UserFormScreen(
    navController: NavController,
    name: String,
    age: String,
    carnet: String,
) {
    // Los campos son recibidos como parámetros
    var nameState by remember { mutableStateOf(name) }
    var ageState by remember { mutableStateOf(age.toString()) }
    var carnetState by remember { mutableStateOf(carnet.toString()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Campo de texto para "Hola: _"
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Hola:", fontSize = 24.sp)
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = nameState,
                onValueChange = { nameState = it },
                textStyle = TextStyle(fontSize = 24.sp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para "Tu edad es: _"
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Tu edad es:", fontSize = 24.sp)
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = ageState,
                onValueChange = { ageState = it },
                textStyle = TextStyle(fontSize = 24.sp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para "Carné: _"
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Carné:", fontSize = 24.sp)
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = carnetState,
                onValueChange = { carnetState = it },
                textStyle = TextStyle(fontSize = 24.sp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botón de regresar
        Button(
            onClick = { navController.navigate("landingPage") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.size(150.dp, 50.dp)
        ) {
            Text(text = "Regresar", color = Color.White, fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewScreen(){
    // Vista previa de la pantalla con valores de ejemplo
//    UserFormScreen(navController = NavController, name = "John Doe", age = "25", carnet = "12345")
}
