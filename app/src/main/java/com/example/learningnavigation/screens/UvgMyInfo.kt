package com.example.learningnavigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UVGMyInfoScreen(
navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable { navController.navigate("userInputForm") },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Texto "UVG"
        Text(
            text = "UVG",
            fontSize = 48.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Texto "My Info"
        Text(
            text = "My Info",
            fontSize = 36.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUVGMyInfoScreen() {

}
