package com.example.learningnavigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserInputForm(
    onContinueClick: (String, String, String) -> Unit,
) {
    var name by remember { mutableStateOf("") }
    var carnet by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    val isFormValid = name.isNotBlank() && carnet.isNotBlank() && age.isNotBlank()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Campo para ingresar nombre
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Ingresa tu nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Campo para ingresar carné
        OutlinedTextField(
            value = carnet,
            onValueChange = { carnet = it },
            label = { Text("Ingresa tu carné") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Campo para ingresar edad
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Ingresa tu edad") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = { onContinueClick(name, carnet, age) },
            enabled = isFormValid,
            colors = ButtonDefaults.buttonColors(containerColor = if (isFormValid) Color.Blue else Color.Gray),
            modifier = Modifier.size(150.dp, 50.dp)
        ) {
            Text(text = "Continuar", color = Color.White, fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserInputForm() {
//    UserInputForm(onContinueClick={name, carnet, age})
}
