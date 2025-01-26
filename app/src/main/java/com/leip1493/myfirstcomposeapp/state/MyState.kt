package com.leip1493.myfirstcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun MyState(modifier:Modifier) {
    val number = remember { mutableIntStateOf(0) }

    Text("Pulsame ${number.intValue}", modifier = modifier.clickable {
        number.value += 1
    })

}