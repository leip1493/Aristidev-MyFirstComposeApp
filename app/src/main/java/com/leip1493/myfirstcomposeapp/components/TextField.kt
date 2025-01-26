package com.leip1493.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.math.max

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var input by remember { mutableStateOf("Inicializado") }
    var value by remember { mutableStateOf("") }

    Column(modifier) {
        MyTextField(input) { input = it }
        MyTextField2(value){ value = it}
    }
}

@Composable
fun MyTextField(name: String, onChange: (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = {
            onChange(it)
        },
        readOnly = name.isEmpty()
    )
}

@Composable
fun MyTextField2(value: String, onChange: (String) -> Unit) {
    TextField(
        value = value,
        placeholder = {
            Text("Lorem ipsum")
        },
        label = {
            Text("Input")
        },
        onValueChange = {
            onChange(it)
        }
    )
}