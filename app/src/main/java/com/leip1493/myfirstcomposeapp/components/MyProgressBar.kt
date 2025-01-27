package com.leip1493.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyProgressBar(modifier: Modifier) {
    var showLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            Spacer(Modifier.size(32.dp))
            LinearProgressIndicator(
                progress = { 0.1f },
                color = Color.Black,
                trackColor = Color.Green,
            )
        }
        Spacer(Modifier.size(40.dp))
        Button(onClick = { showLoading = !showLoading }) {
            Text("Cargar Perfil")
        }
    }
}

@Composable
fun MyProgressAdvanced(modifier: Modifier) {
    var progress by rememberSaveable { mutableStateOf(0f) }

    Column(
        modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = { progress })
        LinearProgressIndicator(progress = { progress })
        Row {
            Button(onClick = { progress += 0.1f }) {
                Text("Incrementar")
            }
            Button(onClick = { progress -= 0.1f }) {
                Text("Reducir")
            }
        }
    }
}