package com.leip1493.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var input by remember { mutableStateOf("Inicializado") }
    var value by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Column(modifier) {
        MyTextField(input) { input = it }
        MyTextField2(value) { value = it }
        MyAdvancedTextField(value) { value = it }
        MyPasswordTextField(password) { password = it }
        Spacer(Modifier.height(20.dp))
        MyOutlinedTextField(value) { value = it}
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

@Composable
fun MyAdvancedTextField(value: String, onChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = {
            if (it.contains("a")) {
                onChange(it.replace("a", "X"))
            } else {
                onChange(it)
            }
        }
    )
}

@Composable
fun MyPasswordTextField(password: String, onValueChange: (String) -> Unit) {
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    TextField(
        value = password,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Introduce tu contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(
                text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier.clickable { passwordHidden = !passwordHidden })
        }
    )
}

@Composable
fun MyOutlinedTextField(value: String, onChange: (String) -> Unit) {
    OutlinedTextField(value, onValueChange = { onChange(it) })
}