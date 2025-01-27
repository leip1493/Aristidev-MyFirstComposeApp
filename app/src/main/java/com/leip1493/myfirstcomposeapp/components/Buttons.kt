package com.leip1493.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButtons(modifier: Modifier) {
    Column(modifier) {
        Button(
            modifier = Modifier,
            onClick = {
                Log.i("Luis", "Boton pulsado")
            },
            enabled = true,
            shape = RoundedCornerShape(0),
            border = BorderStroke(3.dp,Color.Red),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.Gray,
                disabledContentColor = Color.Yellow,
                disabledContainerColor = Color.Green
            )

        ) {
            Text("Pulsame")
        }

        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Blue,
                containerColor = Color.Green,
                disabledContentColor = Color.Yellow,
                disabledContainerColor = Color.Green
            )
        ) {
            Text("Outlined")
        }

        TextButton(onClick = {}) {
            Text("Text Button")
        }

        FilledTonalButton(onClick = {}) {
            Text("FilledTonalButton")
        }
    }
}