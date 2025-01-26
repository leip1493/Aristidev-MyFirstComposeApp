package com.leip1493.myfirstcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyState(modifier:Modifier) {
    // 1 - De esta manera no hace falta andar accediendo con .value
    // 2 - Con el saveable podemos girar la pantalla sin perder el estado
    var number by rememberSaveable { mutableIntStateOf(0) }

    Text("Pulsame ${number}", modifier = modifier.clickable {
        number += 1
    })

}