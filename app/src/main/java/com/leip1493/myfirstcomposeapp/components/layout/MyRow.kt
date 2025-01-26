package com.leip1493.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxSize().horizontalScroll(rememberScrollState()),
//        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Green))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Green))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Green))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Green))
    }
}