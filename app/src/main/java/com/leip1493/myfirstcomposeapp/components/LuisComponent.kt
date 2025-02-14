package com.leip1493.myfirstcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun LuisComponent() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Luis", modifier = Modifier.testTag("Luis1"))
        Text(text = "Lorem")
        Text(text = "Ipsum")
        Text(text = "Luis", modifier = Modifier.testTag("Luis2"))

        Image(Icons.Default.Add, contentDescription = "add")

    }

    var name by remember { mutableStateOf("Pepito") }

    Column(Modifier.fillMaxSize()) {
        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.testTag("textFieldName")
        )
        Text(text = "Te llamas $name", modifier = Modifier.testTag("textGreeting"))
    }
}