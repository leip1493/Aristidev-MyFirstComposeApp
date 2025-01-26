package com.leip1493.myfirstcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyState(modifier: Modifier) {
    // Se debe subir el estado al padre de todos los composables
    var number1 by rememberSaveable { mutableIntStateOf(0) }
    var number2 by rememberSaveable { mutableIntStateOf(0) }

    Column(modifier = modifier) {
        StateExample1(number1) { number1 += 1 }
        StateExample2(number2) { number2 += 1 }
    }

}

@Composable
fun StateExample1(number: Int, onClick: () -> Unit) {
    Text("Pulsame A ${number}", modifier = Modifier.clickable {
        onClick()
    })
}

@Composable
fun StateExample2(number: Int, onClick: () -> Unit) {
    Text("Pulsame B ${number}", modifier = Modifier.clickable {
        onClick()
    })
}